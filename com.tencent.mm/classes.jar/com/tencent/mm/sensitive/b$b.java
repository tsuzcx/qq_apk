package com.tencent.mm.sensitive;

import android.net.Uri;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Contacts;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video.Media;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.a.k;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sensitive/ContentProviderHooker$MyInvokeHandler;", "Ljava/lang/reflect/InvocationHandler;", "originObject", "", "(Ljava/lang/Object;)V", "getOriginObject", "()Ljava/lang/Object;", "invoke", "proxy", "method", "Ljava/lang/reflect/Method;", "args", "", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "sensitive_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b$b
  implements InvocationHandler
{
  private final Object acsA;
  
  public b$b(Object paramObject)
  {
    AppMethodBeat.i(240883);
    this.acsA = paramObject;
    AppMethodBeat.o(240883);
  }
  
  public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    com.tencent.mm.sensitive.ui.a locala = null;
    int m = 1;
    AppMethodBeat.i(240885);
    paramObject = com.tencent.mm.sensitive.ui.a.acvO;
    label53:
    int i;
    label88:
    label96:
    label105:
    label112:
    int k;
    int j;
    if (!com.tencent.mm.sensitive.ui.a.iUw())
    {
      StringBuilder localStringBuilder;
      if (paramMethod == null)
      {
        paramObject = null;
        if (!s.p(paramObject, "query")) {
          break label364;
        }
        localStringBuilder = new StringBuilder("[contentProvider], method:");
        if (paramMethod != null) {
          break label192;
        }
        paramObject = null;
        Log.i("Kenneth-methodCall", paramObject + ", args:" + paramArrayOfObject);
        if (paramArrayOfObject == null) {
          break label212;
        }
        if (paramArrayOfObject.length != 0) {
          break label200;
        }
        i = 1;
        if (i != 0) {
          break label206;
        }
        i = 1;
        if (i != 1) {
          break label212;
        }
        i = 1;
        if (i == 0) {
          break label218;
        }
        paramObject = paramArrayOfObject;
        if (paramObject == null) {
          break label416;
        }
        int n = paramObject.length;
        k = 0;
        i = 0;
        j = 0;
        label129:
        if (k >= n) {
          break label410;
        }
        localStringBuilder = paramObject[k];
        if ((!(localStringBuilder instanceof Uri)) || ((!s.p(localStringBuilder, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)) && (!s.p(localStringBuilder, MediaStore.Video.Media.EXTERNAL_CONTENT_URI)))) {
          break label223;
        }
        j = 1;
      }
      for (;;)
      {
        k += 1;
        break label129;
        paramObject = paramMethod.getName();
        break;
        label192:
        paramObject = paramMethod.getName();
        break label53;
        label200:
        i = 0;
        break label88;
        label206:
        i = 0;
        break label96;
        label212:
        i = 0;
        break label105;
        label218:
        paramObject = null;
        break label112;
        label223:
        if ((!(localStringBuilder instanceof Uri)) || ((!s.p(localStringBuilder, ContactsContract.CommonDataKinds.Phone.CONTENT_URI)) && (!s.p(localStringBuilder, ContactsContract.Contacts.CONTENT_URI)))) {
          break label259;
        }
        i = 1;
      }
      label259:
      if ((!(localStringBuilder instanceof Object[])) || (!k.contains((Object[])localStringBuilder, "date_added"))) {
        break label407;
      }
      k = m;
    }
    for (;;)
    {
      if (((j != 0) || (i != 0)) && (k == 0))
      {
        if (i != 0) {
          paramObject = "queryContact";
        }
        for (;;)
        {
          locala = com.tencent.mm.sensitive.ui.a.acvO;
          if (!com.tencent.mm.sensitive.ui.a.bus(paramObject)) {
            break;
          }
          AppMethodBeat.o(240885);
          return null;
          if (j != 0) {
            paramObject = "queryMedia";
          } else {
            paramObject = "";
          }
        }
        paramObject = com.tencent.mm.plugin.expt.hellhound.core.a.b.a.zBn;
        paramObject = a.a.d(this.acsA, paramMethod, paramArrayOfObject);
        AppMethodBeat.o(240885);
        return paramObject;
      }
      try
      {
        label364:
        paramObject = com.tencent.mm.plugin.expt.hellhound.core.a.b.a.zBn;
        paramObject = a.a.d(this.acsA, paramMethod, paramArrayOfObject);
        AppMethodBeat.o(240885);
        return paramObject;
      }
      finally
      {
        for (;;)
        {
          Log.i(b.aUw(), s.X("invoke method catch err:", paramObject.getMessage()));
          paramObject = locala;
        }
      }
      label407:
      break;
      label410:
      k = 0;
      continue;
      label416:
      k = 0;
      i = 0;
      j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.sensitive.b.b
 * JD-Core Version:    0.7.0.1
 */