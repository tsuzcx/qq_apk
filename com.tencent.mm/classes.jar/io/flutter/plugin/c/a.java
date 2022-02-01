package io.flutter.plugin.c;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.LocaleList;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.c.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Locale.LanguageRange;

public final class a
{
  private final d SOa;
  private final Context context;
  
  public a(Context paramContext, d paramd)
  {
    this.context = paramContext;
    this.SOa = paramd;
  }
  
  public final void j(Configuration paramConfiguration)
  {
    AppMethodBeat.i(214856);
    ArrayList localArrayList = new ArrayList();
    if (Build.VERSION.SDK_INT >= 24)
    {
      paramConfiguration = paramConfiguration.getLocales();
      int j = paramConfiguration.size();
      int i = 0;
      while (i < j)
      {
        localArrayList.add(paramConfiguration.get(i));
        i += 1;
      }
    }
    localArrayList.add(paramConfiguration.locale);
    this.SOa.km(localArrayList);
    AppMethodBeat.o(214856);
  }
  
  public final Locale ko(List<Locale> paramList)
  {
    AppMethodBeat.i(214855);
    if (paramList.isEmpty())
    {
      AppMethodBeat.o(214855);
      return null;
    }
    Object localObject2;
    int i;
    Object localObject3;
    if (Build.VERSION.SDK_INT >= 26)
    {
      localObject1 = new ArrayList();
      localObject2 = this.context.getResources().getConfiguration().getLocales();
      int j = ((LocaleList)localObject2).size();
      i = 0;
      while (i < j)
      {
        localObject3 = ((LocaleList)localObject2).get(i);
        ((List)localObject1).add(new Locale.LanguageRange(((Locale)localObject3).toString().replace("_", "-")));
        ((List)localObject1).add(new Locale.LanguageRange(((Locale)localObject3).getLanguage()));
        ((List)localObject1).add(new Locale.LanguageRange(((Locale)localObject3).getLanguage() + "-*"));
        i += 1;
      }
      localObject1 = Locale.lookup((List)localObject1, paramList);
      if (localObject1 != null)
      {
        AppMethodBeat.o(214855);
        return localObject1;
      }
      paramList = (Locale)paramList.get(0);
      AppMethodBeat.o(214855);
      return paramList;
    }
    if (Build.VERSION.SDK_INT >= 24)
    {
      localObject1 = this.context.getResources().getConfiguration().getLocales();
      i = 0;
      while (i < ((LocaleList)localObject1).size())
      {
        localObject2 = ((LocaleList)localObject1).get(i);
        localObject3 = paramList.iterator();
        Locale localLocale;
        while (((Iterator)localObject3).hasNext())
        {
          localLocale = (Locale)((Iterator)localObject3).next();
          if (((Locale)localObject2).equals(localLocale))
          {
            AppMethodBeat.o(214855);
            return localLocale;
          }
        }
        localObject3 = paramList.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localLocale = (Locale)((Iterator)localObject3).next();
          if (((Locale)localObject2).getLanguage().equals(localLocale.toLanguageTag()))
          {
            AppMethodBeat.o(214855);
            return localLocale;
          }
        }
        localObject3 = paramList.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localLocale = (Locale)((Iterator)localObject3).next();
          if (((Locale)localObject2).getLanguage().equals(localLocale.getLanguage()))
          {
            AppMethodBeat.o(214855);
            return localLocale;
          }
        }
        i += 1;
      }
      paramList = (Locale)paramList.get(0);
      AppMethodBeat.o(214855);
      return paramList;
    }
    Object localObject1 = this.context.getResources().getConfiguration().locale;
    if (localObject1 != null)
    {
      localObject2 = paramList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Locale)((Iterator)localObject2).next();
        if (((Locale)localObject1).equals(localObject3))
        {
          AppMethodBeat.o(214855);
          return localObject3;
        }
      }
      localObject2 = paramList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Locale)((Iterator)localObject2).next();
        if (((Locale)localObject1).getLanguage().equals(((Locale)localObject3).toString()))
        {
          AppMethodBeat.o(214855);
          return localObject3;
        }
      }
    }
    paramList = (Locale)paramList.get(0);
    AppMethodBeat.o(214855);
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     io.flutter.plugin.c.a
 * JD-Core Version:    0.7.0.1
 */