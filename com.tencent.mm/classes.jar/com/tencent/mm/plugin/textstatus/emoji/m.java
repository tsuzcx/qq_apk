package com.tencent.mm.plugin.textstatus.emoji;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.b.h;
import com.tencent.mm.plugin.textstatus.proto.ap;
import com.tencent.mm.plugin.textstatus.proto.aq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.a;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/emoji/TextStatusEmojiUtil;", "", "()V", "TAG", "", "emojiSubTypeArrayList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiSubTypeData;", "Lkotlin/collections/ArrayList;", "getAllEmojiByType", "Lcom/tencent/mm/plugin/textstatus/proto/WxImeEmojiDataList;", "context", "Landroid/content/Context;", "typeName", "subTypeName", "getLastEmojiSubType", "emojiType", "getSubTypeByEmojiType", "saveLastEmojiSubType", "", "subType", "plugin-textstatus_release"})
public final class m
{
  private static final ArrayList<f> DGZ;
  public static final m MBp;
  
  static
  {
    AppMethodBeat.i(232428);
    MBp = new m();
    ArrayList localArrayList = new ArrayList(13);
    DGZ = localArrayList;
    String str = MMApplicationContext.getContext().getString(b.h.MyB);
    p.j(str, "MMApplicationContext.get…us_emoji_subtype_emotion)");
    localArrayList.add(new f(str, "emotion"));
    localArrayList = DGZ;
    str = MMApplicationContext.getContext().getString(b.h.MyG);
    p.j(str, "MMApplicationContext.get…atus_emoji_subtype_limbs)");
    localArrayList.add(new f(str, "limbs"));
    localArrayList = DGZ;
    str = MMApplicationContext.getContext().getString(b.h.MyI);
    p.j(str, "MMApplicationContext.get…tus_emoji_subtype_person)");
    localArrayList.add(new f(str, "person"));
    localArrayList = DGZ;
    str = MMApplicationContext.getContext().getString(b.h.Myz);
    p.j(str, "MMApplicationContext.get…tus_emoji_subtype_animal)");
    localArrayList.add(new f(str, "animal"));
    localArrayList = DGZ;
    str = MMApplicationContext.getContext().getString(b.h.MyA);
    p.j(str, "MMApplicationContext.get…tus_emoji_subtype_botany)");
    localArrayList.add(new f(str, "botany"));
    localArrayList = DGZ;
    str = MMApplicationContext.getContext().getString(b.h.MyH);
    p.j(str, "MMApplicationContext.get…tus_emoji_subtype_nature)");
    localArrayList.add(new f(str, "nature"));
    localArrayList = DGZ;
    str = MMApplicationContext.getContext().getString(b.h.MyE);
    p.j(str, "MMApplicationContext.get…tatus_emoji_subtype_food)");
    localArrayList.add(new f(str, "food"));
    localArrayList = DGZ;
    str = MMApplicationContext.getContext().getString(b.h.MyJ);
    p.j(str, "MMApplicationContext.get…atus_emoji_subtype_place)");
    localArrayList.add(new f(str, "place"));
    localArrayList = DGZ;
    str = MMApplicationContext.getContext().getString(b.h.MyL);
    p.j(str, "MMApplicationContext.get…us_emoji_subtype_traffic)");
    localArrayList.add(new f(str, "traffic"));
    localArrayList = DGZ;
    str = MMApplicationContext.getContext().getString(b.h.MyC);
    p.j(str, "MMApplicationContext.get…s_emoji_subtype_exercise)");
    localArrayList.add(new f(str, "exercise"));
    localArrayList = DGZ;
    str = MMApplicationContext.getContext().getString(b.h.MyF);
    p.j(str, "MMApplicationContext.get…atus_emoji_subtype_goods)");
    localArrayList.add(new f(str, "goods"));
    localArrayList = DGZ;
    str = MMApplicationContext.getContext().getString(b.h.MyK);
    p.j(str, "MMApplicationContext.get…tus_emoji_subtype_symbol)");
    localArrayList.add(new f(str, "symbol"));
    localArrayList = DGZ;
    str = MMApplicationContext.getContext().getString(b.h.MyD);
    p.j(str, "MMApplicationContext.get…tatus_emoji_subtype_flag)");
    localArrayList.add(new f(str, "flag"));
    AppMethodBeat.o(232428);
  }
  
  public static aq T(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(232420);
    p.k(paramContext, "context");
    p.k(paramString1, "typeName");
    p.k(paramString2, "subTypeName");
    paramContext = paramContext.getAssets().open("text_status_emoji/" + paramString2 + ".txt");
    p.j(paramContext, "context.assets.open(file…ASSETS_EMOJI_FILE_SUFFIX)");
    localBufferedReader = new BufferedReader((Reader)new InputStreamReader(paramContext));
    paramContext = new aq();
    for (;;)
    {
      try
      {
        str = localBufferedReader.readLine();
        if (str == null) {
          continue;
        }
        if (str == null) {
          continue;
        }
        localap = new ap();
        switch (paramString1.hashCode())
        {
        }
      }
      catch (IOException paramString1)
      {
        Log.e("WxIme.WxImeEmojiUtil", "getAllEmojiByType " + paramString2 + ' ' + paramString1.getMessage());
      }
      finally
      {
        try
        {
          localBufferedReader.close();
          AppMethodBeat.o(232420);
          return paramContext;
          if (!paramString1.equals("emoji")) {
            continue;
          }
          Object localObject = n.b((CharSequence)str, new String[] { " " });
          localStringBuilder = new StringBuilder();
          localObject = ((List)localObject).iterator();
          if (((Iterator)localObject).hasNext())
          {
            localStringBuilder.append(Character.toChars(Integer.parseInt((String)((Iterator)localObject).next(), a.aFL(16))));
            continue;
            paramContext = finally;
          }
        }
        catch (IOException paramString1)
        {
          try
          {
            String str;
            ap localap;
            StringBuilder localStringBuilder;
            localBufferedReader.close();
            AppMethodBeat.o(232420);
            throw paramContext;
            if (!paramString1.equals("kaoemoji")) {
              continue;
            }
            localap.content = str;
            continue;
            localap.content = localStringBuilder.toString();
            localap.MGH = str;
            continue;
            try
            {
              localBufferedReader.close();
            }
            catch (IOException paramString1)
            {
              Log.e("WxIme.WxImeEmojiUtil", "getAllEmojiByType " + paramString2 + ' ' + paramString1.getMessage());
            }
            continue;
            paramString1 = paramString1;
            Log.e("WxIme.WxImeEmojiUtil", "getAllEmojiByType " + paramString2 + ' ' + paramString1.getMessage());
          }
          catch (IOException paramString1)
          {
            Log.e("WxIme.WxImeEmojiUtil", "getAllEmojiByType " + paramString2 + ' ' + paramString1.getMessage());
            continue;
          }
        }
        continue;
      }
      paramContext.MGI.add(localap);
    }
  }
  
  public static String aLG(String paramString)
  {
    AppMethodBeat.i(232422);
    p.k(paramString, "emojiType");
    Object localObject = com.tencent.mm.plugin.textstatus.k.f.MOw;
    localObject = com.tencent.mm.plugin.textstatus.k.f.getKV();
    if (localObject != null)
    {
      localObject = ((MultiProcessMMKV)localObject).getString(paramString, "emotion");
      paramString = (String)localObject;
      if (localObject != null) {}
    }
    else
    {
      paramString = "emotion";
    }
    AppMethodBeat.o(232422);
    return paramString;
  }
  
  public static ArrayList<f> be(Context paramContext, String paramString)
  {
    AppMethodBeat.i(232421);
    p.k(paramContext, "context");
    p.k(paramString, "typeName");
    switch (paramString.hashCode())
    {
    }
    do
    {
      paramContext = new ArrayList();
      AppMethodBeat.o(232421);
      return paramContext;
    } while (!paramString.equals("emoji"));
    paramContext = DGZ;
    AppMethodBeat.o(232421);
    return paramContext;
  }
  
  public static void ir(String paramString1, String paramString2)
  {
    AppMethodBeat.i(232425);
    p.k(paramString1, "emojiType");
    p.k(paramString2, "subType");
    Object localObject = com.tencent.mm.plugin.textstatus.k.f.MOw;
    localObject = com.tencent.mm.plugin.textstatus.k.f.getKV();
    if (localObject != null)
    {
      localObject = ((MultiProcessMMKV)localObject).edit();
      if (localObject != null)
      {
        ((SharedPreferences.Editor)localObject).putString(paramString1, paramString2);
        AppMethodBeat.o(232425);
        return;
      }
    }
    AppMethodBeat.o(232425);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.emoji.m
 * JD-Core Version:    0.7.0.1
 */