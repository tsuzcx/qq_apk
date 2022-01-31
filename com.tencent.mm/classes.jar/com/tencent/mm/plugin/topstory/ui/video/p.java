package com.tencent.mm.plugin.topstory.ui.video;

import android.content.Intent;
import android.widget.Toast;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.topstory.a.h;
import com.tencent.mm.plugin.topstory.ui.b.g;
import com.tencent.mm.protocal.c.byg;
import com.tencent.mm.protocal.c.rb;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class p
{
  public static final p pGr = new p();
  byg pGs;
  
  static JSONArray cQ(List<rb> paramList)
  {
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    for (;;)
    {
      if (i < paramList.size()) {}
      try
      {
        JSONObject localJSONObject = new JSONObject();
        rb localrb = (rb)paramList.get(i);
        localJSONObject.put("key", localrb.key);
        localJSONObject.put("uintValue", localrb.sOI);
        localJSONObject.put("textValue", localrb.sOJ);
        localJSONArray.put(localJSONObject);
        label82:
        i += 1;
        continue;
        return localJSONArray;
      }
      catch (Exception localException)
      {
        break label82;
      }
    }
  }
  
  public final void a(b paramb, int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1024) {
      if (paramInt2 == -1)
      {
        Toast.makeText(ae.getContext(), b.g.app_shared, 1).show();
        h.a(paramb.bNv(), this.pGs, "1", q.Gj(), "");
      }
    }
    do
    {
      do
      {
        return;
      } while ((paramInt1 != 2048) || (paramInt2 != -1));
      localObject = paramIntent.getStringArrayListExtra("SendMsgUsernames");
    } while ((localObject == null) || (((ArrayList)localObject).size() <= 0));
    paramIntent = new StringBuilder("");
    StringBuilder localStringBuilder = new StringBuilder("");
    Object localObject = ((ArrayList)localObject).iterator();
    if (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (s.fn(str))
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
    h.a(paramb.bNv(), this.pGs, paramIntent.toString(), q.Gj(), localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.p
 * JD-Core Version:    0.7.0.1
 */