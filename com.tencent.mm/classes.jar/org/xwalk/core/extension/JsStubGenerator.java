package org.xwalk.core.extension;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class JsStubGenerator
{
  public static final String MSG_TO_CLASS = "postMessageToClass";
  public static final String MSG_TO_EXTENSION = "postMessageToExtension";
  public static final String MSG_TO_OBJECT = "postMessageToObject";
  public static String TAG = "JsStubGenerator";
  String jsHeader = "var v8tools = requireNative(\"v8tools\");\nvar jsStubModule = requireNative(\"jsStub\");\njsStubModule.init(extension, v8tools);\nvar jsStub = jsStubModule.jsStub;\nvar helper = jsStub.createRootStub(exports);\n";
  ReflectionHelper reflection;
  
  JsStubGenerator(ReflectionHelper paramReflectionHelper)
  {
    this.reflection = paramReflectionHelper;
  }
  
  String[] classGenerator(ReflectionHelper paramReflectionHelper)
  {
    AppMethodBeat.i(155229);
    String str1 = "";
    String str2 = "";
    if (paramReflectionHelper.getEventList() != null)
    {
      str2 = generateEventTarget(paramReflectionHelper);
      str1 = "" + str2;
      str2 = "" + str2;
    }
    Map localMap = paramReflectionHelper.getMembers();
    Iterator localIterator = localMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      ReflectionHelper.MemberInfo localMemberInfo = (ReflectionHelper.MemberInfo)localMap.get((String)localIterator.next());
      if (localMemberInfo.isStatic)
      {
        paramReflectionHelper = "postMessageToClass";
        label127:
        switch (1.$SwitchMap$org$xwalk$core$extension$ReflectionHelper$MemberType[localMemberInfo.type.ordinal()])
        {
        default: 
          paramReflectionHelper = "";
        }
      }
      for (;;)
      {
        if (!localMemberInfo.isStatic) {
          break label222;
        }
        str2 = str2 + paramReflectionHelper;
        break;
        paramReflectionHelper = "postMessageToObject";
        break label127;
        paramReflectionHelper = generateProperty(paramReflectionHelper, localMemberInfo);
        continue;
        paramReflectionHelper = generateMethod(paramReflectionHelper, localMemberInfo, true);
      }
      label222:
      str1 = str1 + paramReflectionHelper;
    }
    AppMethodBeat.o(155229);
    return new String[] { str1, str2 };
  }
  
  String destroyBindingObject(ReflectionHelper paramReflectionHelper)
  {
    AppMethodBeat.i(155230);
    Iterator localIterator = paramReflectionHelper.getMembers().keySet().iterator();
    String str;
    for (paramReflectionHelper = "exports.destroy = function() {\n"; localIterator.hasNext(); paramReflectionHelper = paramReflectionHelper + "delete exports[\"" + str + "\"];\n") {
      str = (String)localIterator.next();
    }
    paramReflectionHelper = paramReflectionHelper + "helper.destroy();\n";
    paramReflectionHelper = paramReflectionHelper + "delete exports[\"__stubHelper\"];\n";
    paramReflectionHelper = paramReflectionHelper + "delete exports[\"destroy\"];\n";
    paramReflectionHelper = paramReflectionHelper + "};";
    AppMethodBeat.o(155230);
    return paramReflectionHelper;
  }
  
  String generate()
  {
    AppMethodBeat.i(155227);
    Object localObject1 = "";
    Object localObject2 = this.reflection.getEntryPoint();
    if (localObject2 != null) {
      localObject1 = generateEntryPoint((ReflectionHelper.MemberInfo)localObject2);
    }
    label93:
    ReflectionHelper.MemberInfo localMemberInfo;
    if (((String)localObject1).length() > 0)
    {
      localObject2 = localObject1;
      localObject1 = localObject2;
      if (this.reflection.getEventList() != null) {
        localObject1 = (String)localObject2 + generateEventTarget(this.reflection);
      }
      localObject2 = this.reflection.getMembers();
      Iterator localIterator = ((Map)localObject2).keySet().iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localMemberInfo = (ReflectionHelper.MemberInfo)((Map)localObject2).get((String)localIterator.next());
      } while (localMemberInfo.isEntryPoint);
      switch (1.$SwitchMap$org$xwalk$core$extension$ReflectionHelper$MemberType[localMemberInfo.type.ordinal()])
      {
      }
    }
    for (;;)
    {
      break label93;
      localObject2 = this.jsHeader;
      break;
      localObject1 = (String)localObject1 + generateProperty("postMessageToExtension", localMemberInfo);
      break label93;
      localObject1 = (String)localObject1 + generateMethod("postMessageToExtension", localMemberInfo, true);
      break label93;
      localObject1 = (String)localObject1 + generateConstructor(localMemberInfo, true);
    }
    localObject1 = (String)localObject1 + "\n";
    AppMethodBeat.o(155227);
    return localObject1;
  }
  
  String generateConstructor(ReflectionHelper.MemberInfo paramMemberInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(155238);
    String str1 = paramMemberInfo.jsName;
    String str2 = getPrototypeName(str1);
    String str3 = getArgString((Method)paramMemberInfo.accesser, false);
    Object localObject = this.reflection.getConstructorReflection(str1);
    paramMemberInfo = classGenerator((ReflectionHelper)localObject);
    localObject = String.format("function %s(exports, helper){\n%s\n%s\n}\n", new Object[] { str2, paramMemberInfo[0], destroyBindingObject((ReflectionHelper)localObject) });
    str2 = String.format("function %s(%s) {\nvar newObject = this;\nvar objectId =\nNumber(helper.invokeNative(\"%s\", \"+%s\", [%s], true));\nif (!objectId) throw \"Error to create instance for constructor:%s.\";\nvar objectHelper = jsStub.getHelper(newObject, helper);\nobjectHelper.objectId = objectId;\nobjectHelper.constructorJsName = \"%s\";\nobjectHelper.registerLifecycleTracker();%s(newObject, objectHelper);\nhelper.addBindingObject(objectId, newObject);}\nhelper.constructors[\"%s\"] = %s;\n", new Object[] { str1, str3, "postMessageToExtension", str1, str3, str1, str1, str2, str1, str1 });
    str3 = String.format("(function(exports, helper){\n  helper.constructorJsName = \"%s\";\n%s\n})(%s, jsStub.getHelper(%s, helper));\n", new Object[] { str1, paramMemberInfo[1], str1, str1 });
    if (paramBoolean) {}
    for (paramMemberInfo = String.format("exports[\"%s\"] = %s;\n", new Object[] { str1, str1 });; paramMemberInfo = "")
    {
      paramMemberInfo = (String)localObject + str2 + str3 + paramMemberInfo;
      AppMethodBeat.o(155238);
      return paramMemberInfo;
    }
  }
  
  String generateEntryPoint(ReflectionHelper.MemberInfo paramMemberInfo)
  {
    AppMethodBeat.i(155228);
    if (paramMemberInfo.type == ReflectionHelper.MemberType.JS_PROPERTY)
    {
      paramMemberInfo = ((Field)paramMemberInfo.accesser).getType().getSimpleName();
      paramMemberInfo = this.jsHeader + String.format("%s(exports, helper);\n", new Object[] { getPrototypeName(paramMemberInfo) });
      AppMethodBeat.o(155228);
      return paramMemberInfo;
    }
    if (paramMemberInfo.type == ReflectionHelper.MemberType.JS_METHOD)
    {
      paramMemberInfo = String.format("exports = %s;\n %s\n %s", new Object[] { getInternalName(paramMemberInfo.jsName), this.jsHeader, generateMethod("postMessageToExtension", paramMemberInfo, false) });
      AppMethodBeat.o(155228);
      return paramMemberInfo;
    }
    if (paramMemberInfo.type == ReflectionHelper.MemberType.JS_CONSTRUCTOR)
    {
      paramMemberInfo = String.format("exports = %s;\n %s\n %s", new Object[] { paramMemberInfo.jsName, this.jsHeader, generateConstructor(paramMemberInfo, false) });
      AppMethodBeat.o(155228);
      return paramMemberInfo;
    }
    AppMethodBeat.o(155228);
    return "";
  }
  
  String generateEventTarget(ReflectionHelper paramReflectionHelper)
  {
    AppMethodBeat.i(155231);
    String[] arrayOfString = paramReflectionHelper.getEventList();
    if ((arrayOfString == null) || (arrayOfString.length == 0))
    {
      AppMethodBeat.o(155231);
      return "";
    }
    paramReflectionHelper = "jsStub.makeEventTarget(exports);\n";
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      paramReflectionHelper = paramReflectionHelper + "helper.addEvent(\"" + str + "\");\n";
      i += 1;
    }
    AppMethodBeat.o(155231);
    return paramReflectionHelper;
  }
  
  String generateMethod(String paramString, ReflectionHelper.MemberInfo paramMemberInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(155235);
    if (paramMemberInfo.withPromise)
    {
      paramString = generatePromiseMethod(paramString, paramMemberInfo);
      AppMethodBeat.o(155235);
      return paramString;
    }
    String str1 = paramMemberInfo.jsName;
    Object localObject = (Method)paramMemberInfo.accesser;
    String str2 = getInternalName(str1);
    ((Method)localObject).getParameterAnnotations();
    String str3 = getArgString((Method)localObject, paramMemberInfo.withPromise);
    boolean bool;
    if (!((Method)localObject).getReturnType().equals(Void.TYPE))
    {
      bool = true;
      localObject = new StringBuilder("function %s(%s) {\n");
      if (!bool) {
        break label217;
      }
      paramMemberInfo = "  return ";
      label105:
      paramMemberInfo = String.format(paramMemberInfo + "helper.invokeNative(\"%s\", \"%s\", [%s], %b);\n};\n", new Object[] { str2, str3, paramString, str1, str3, Boolean.valueOf(bool) });
      if (!paramBoolean) {
        break label224;
      }
    }
    label217:
    label224:
    for (paramString = String.format("exports[\"%s\"] = %s;\n", new Object[] { str1, str2 });; paramString = "")
    {
      paramString = paramMemberInfo + paramString;
      AppMethodBeat.o(155235);
      return paramString;
      bool = false;
      break;
      paramMemberInfo = "  ";
      break label105;
    }
  }
  
  String generatePromiseMethod(String paramString, ReflectionHelper.MemberInfo paramMemberInfo)
  {
    AppMethodBeat.i(155233);
    String str2 = paramMemberInfo.jsName;
    String str1;
    if (paramMemberInfo.wrapArgs.length() > 0)
    {
      str1 = paramMemberInfo.wrapArgs;
      if (paramMemberInfo.wrapReturns.length() <= 0) {
        break label85;
      }
    }
    label85:
    for (paramMemberInfo = paramMemberInfo.wrapReturns;; paramMemberInfo = "null")
    {
      paramString = String.format("jsStub.addMethodWithPromise(\"%s\", exports, \"%s\", %s, %s);\n", new Object[] { paramString, str2, str1, paramMemberInfo });
      AppMethodBeat.o(155233);
      return paramString;
      str1 = "null";
      break;
    }
  }
  
  String generateProperty(String paramString, ReflectionHelper.MemberInfo paramMemberInfo)
  {
    AppMethodBeat.i(155232);
    paramString = String.format("jsStub.defineProperty(\"%s\", exports, \"%s\", %b);\n", new Object[] { paramString, paramMemberInfo.jsName, Boolean.valueOf(paramMemberInfo.isWritable) });
    AppMethodBeat.o(155232);
    return paramString;
  }
  
  String getArgString(Method paramMethod, boolean paramBoolean)
  {
    AppMethodBeat.i(155234);
    if (paramMethod == null)
    {
      AppMethodBeat.o(155234);
      return "";
    }
    Class[] arrayOfClass = paramMethod.getParameterTypes();
    paramMethod.getParameterAnnotations();
    paramMethod = "";
    if (paramBoolean) {}
    for (int i = arrayOfClass.length - 1;; i = arrayOfClass.length)
    {
      int j = 0;
      while (j < i)
      {
        Object localObject = arrayOfClass[j];
        String str = "arg" + j + "_" + ((Class)localObject).getSimpleName();
        localObject = paramMethod;
        if (paramMethod.length() > 0) {
          localObject = paramMethod + ", ";
        }
        paramMethod = (String)localObject + str;
        j += 1;
      }
    }
    AppMethodBeat.o(155234);
    return paramMethod;
  }
  
  String getInternalName(String paramString)
  {
    AppMethodBeat.i(155236);
    paramString = "__".concat(String.valueOf(paramString));
    AppMethodBeat.o(155236);
    return paramString;
  }
  
  String getPrototypeName(String paramString)
  {
    AppMethodBeat.i(155237);
    paramString = "__" + paramString + "_prototype";
    AppMethodBeat.o(155237);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     org.xwalk.core.extension.JsStubGenerator
 * JD-Core Version:    0.7.0.1
 */