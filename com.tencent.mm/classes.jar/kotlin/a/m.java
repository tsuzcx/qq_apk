package kotlin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.aa;
import kotlin.ac;
import kotlin.af;
import kotlin.g.b.s;
import kotlin.y;

@Metadata(d1={""}, d2={"contentDeepEqualsImpl", "", "T", "", "other", "contentDeepEquals", "([Ljava/lang/Object;[Ljava/lang/Object;)Z", "contentDeepToStringImpl", "", "contentDeepToString", "([Ljava/lang/Object;)Ljava/lang/String;", "contentDeepToStringInternal", "", "result", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "processed", "", "contentDeepToStringInternal$ArraysKt__ArraysKt", "([Ljava/lang/Object;Ljava/lang/StringBuilder;Ljava/util/List;)V", "flatten", "", "([[Ljava/lang/Object;)Ljava/util/List;", "ifEmpty", "R", "C", "defaultValue", "Lkotlin/Function0;", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isNullOrEmpty", "([Ljava/lang/Object;)Z", "unzip", "Lkotlin/Pair;", "([Lkotlin/Pair;)Lkotlin/Pair;", "kotlin-stdlib"}, k=5, mv={1, 5, 1}, xi=1, xs="kotlin/collections/ArraysKt")
public class m
  extends l
{
  public static final <T> void a(T[] paramArrayOfT, StringBuilder paramStringBuilder, List<Object[]> paramList)
  {
    AppMethodBeat.i(191110);
    if (paramList.contains(paramArrayOfT))
    {
      paramStringBuilder.append("[...]");
      AppMethodBeat.o(191110);
      return;
    }
    paramList.add(paramArrayOfT);
    paramStringBuilder.append('[');
    int j = paramArrayOfT.length;
    int i = 0;
    if (i < j)
    {
      if (i != 0) {
        paramStringBuilder.append(", ");
      }
      Object localObject = paramArrayOfT[i];
      if (localObject == null) {
        paramStringBuilder.append("null");
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localObject instanceof Object[]))
        {
          a((Object[])localObject, paramStringBuilder, paramList);
        }
        else if ((localObject instanceof byte[]))
        {
          localObject = Arrays.toString((byte[])localObject);
          s.s(localObject, "java.util.Arrays.toString(this)");
          paramStringBuilder.append((String)localObject);
        }
        else if ((localObject instanceof short[]))
        {
          localObject = Arrays.toString((short[])localObject);
          s.s(localObject, "java.util.Arrays.toString(this)");
          paramStringBuilder.append((String)localObject);
        }
        else if ((localObject instanceof int[]))
        {
          localObject = Arrays.toString((int[])localObject);
          s.s(localObject, "java.util.Arrays.toString(this)");
          paramStringBuilder.append((String)localObject);
        }
        else if ((localObject instanceof long[]))
        {
          localObject = Arrays.toString((long[])localObject);
          s.s(localObject, "java.util.Arrays.toString(this)");
          paramStringBuilder.append((String)localObject);
        }
        else if ((localObject instanceof float[]))
        {
          localObject = Arrays.toString((float[])localObject);
          s.s(localObject, "java.util.Arrays.toString(this)");
          paramStringBuilder.append((String)localObject);
        }
        else if ((localObject instanceof double[]))
        {
          localObject = Arrays.toString((double[])localObject);
          s.s(localObject, "java.util.Arrays.toString(this)");
          paramStringBuilder.append((String)localObject);
        }
        else if ((localObject instanceof char[]))
        {
          localObject = Arrays.toString((char[])localObject);
          s.s(localObject, "java.util.Arrays.toString(this)");
          paramStringBuilder.append((String)localObject);
        }
        else if ((localObject instanceof boolean[]))
        {
          localObject = Arrays.toString((boolean[])localObject);
          s.s(localObject, "java.util.Arrays.toString(this)");
          paramStringBuilder.append((String)localObject);
        }
        else
        {
          label418:
          String str;
          if ((localObject instanceof y))
          {
            localObject = (y)localObject;
            if (localObject != null)
            {
              localObject = ((y)localObject).aiuP;
              if (localObject != null) {
                if (localObject == null) {
                  break label491;
                }
              }
            }
            label491:
            for (localObject = y.dE((byte[])localObject);; localObject = null)
            {
              str = p.a((Iterable)localObject, (CharSequence)", ", (CharSequence)"[", (CharSequence)"]", 0, null, null, 56);
              localObject = str;
              if (str == null) {
                localObject = "null";
              }
              paramStringBuilder.append((String)localObject);
              break;
              localObject = null;
              break label418;
            }
          }
          if ((localObject instanceof af))
          {
            localObject = (af)localObject;
            if (localObject != null)
            {
              localObject = ((af)localObject).aiuW;
              label524:
              if (localObject != null) {
                if (localObject == null) {
                  break label597;
                }
              }
            }
            label597:
            for (localObject = af.c((short[])localObject);; localObject = null)
            {
              str = p.a((Iterable)localObject, (CharSequence)", ", (CharSequence)"[", (CharSequence)"]", 0, null, null, 56);
              localObject = str;
              if (str == null) {
                localObject = "null";
              }
              paramStringBuilder.append((String)localObject);
              break;
              localObject = null;
              break label524;
            }
          }
          if ((localObject instanceof aa))
          {
            localObject = (aa)localObject;
            if (localObject != null)
            {
              localObject = ((aa)localObject).aiuR;
              label630:
              if (localObject != null) {
                if (localObject == null) {
                  break label703;
                }
              }
            }
            label703:
            for (localObject = aa.X((int[])localObject);; localObject = null)
            {
              str = p.a((Iterable)localObject, (CharSequence)", ", (CharSequence)"[", (CharSequence)"]", 0, null, null, 56);
              localObject = str;
              if (str == null) {
                localObject = "null";
              }
              paramStringBuilder.append((String)localObject);
              break;
              localObject = null;
              break label630;
            }
          }
          if ((localObject instanceof ac))
          {
            localObject = (ac)localObject;
            if (localObject != null)
            {
              localObject = ((ac)localObject).aiuT;
              label736:
              if (localObject != null) {
                if (localObject == null) {
                  break label809;
                }
              }
            }
            label809:
            for (localObject = ac.j((long[])localObject);; localObject = null)
            {
              str = p.a((Iterable)localObject, (CharSequence)", ", (CharSequence)"[", (CharSequence)"]", 0, null, null, 56);
              localObject = str;
              if (str == null) {
                localObject = "null";
              }
              paramStringBuilder.append((String)localObject);
              break;
              localObject = null;
              break label736;
            }
          }
          paramStringBuilder.append(localObject.toString());
        }
      }
    }
    paramStringBuilder.append(']');
    paramList.remove(p.oE(paramList));
    AppMethodBeat.o(191110);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlin.a.m
 * JD-Core Version:    0.7.0.1
 */