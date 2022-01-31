package com.tencent.mm.plugin.topstory.ui.video;

import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.topstory.a.h;
import com.tencent.mm.protocal.protobuf.ckx;
import com.tencent.mm.protocal.protobuf.up;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class p
{
  public static final p tjM;
  ckx tjN;
  
  static
  {
    AppMethodBeat.i(1801);
    tjM = new p();
    AppMethodBeat.o(1801);
  }
  
  static JSONArray dS(List<up> paramList)
  {
    AppMethodBeat.i(1800);
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    for (;;)
    {
      if (i < paramList.size()) {}
      try
      {
        JSONObject localJSONObject = new JSONObject();
        up localup = (up)paramList.get(i);
        localJSONObject.put("key", localup.key);
        localJSONObject.put("uintValue", localup.wMM);
        localJSONObject.put("textValue", localup.wMN);
        localJSONArray.put(localJSONObject);
        label88:
        i += 1;
        continue;
        AppMethodBeat.o(1800);
        return localJSONArray;
      }
      catch (Exception localException)
      {
        break label88;
      }
    }
  }
  
  static boolean h(ckx paramckx)
  {
    return (paramckx.xVm != 100201L) && (paramckx.xVm != 100203L);
  }
  
  public final void a(b paramb, int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(1799);
    if (paramInt1 == 1024)
    {
      if (paramInt2 == -1)
      {
        Toast.makeText(ah.getContext(), 2131297076, 1).show();
        h.a(paramb.cJf(), this.tjN, "1", r.Zn(), "");
        AppMethodBeat.o(1799);
      }
    }
    else if ((paramInt1 == 2048) && (paramInt2 == -1))
    {
      Object localObject = paramIntent.getStringArrayListExtra("SendMsgUsernames");
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        paramIntent = new StringBuilder("");
        StringBuilder localStringBuilder = new StringBuilder("");
        localObject = ((ArrayList)localObject).iterator();
        if (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          if (t.lA(str))
          {
            paramIntent.append(3);
            paramIntent.append(";");
          }
          for (;;)
          {
            localStringBuilder.append(str);
            localStringBuilder.append(";");
            break;
            paramIntent.append(2);
            paramIntent.append(";");
          }
        }
        h.a(paramb.cJf(), this.tjN, paramIntent.toString(), r.Zn(), localStringBuilder.toString());
      }
    }
    AppMethodBeat.o(1799);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.p
 * JD-Core Version:    0.7.0.1
 */