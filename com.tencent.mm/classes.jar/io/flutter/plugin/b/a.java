package io.flutter.plugin.b;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.LocaleList;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.b.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Locale.LanguageRange;

public class a
{
  private final e aapZ;
  private final Context context;
  
  public a(Context paramContext, e parame)
  {
    this.context = paramContext;
    this.aapZ = parame;
  }
  
  public final void i(Configuration paramConfiguration)
  {
    AppMethodBeat.i(255238);
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
    this.aapZ.lg(localArrayList);
    AppMethodBeat.o(255238);
  }
  
  public final Locale li(List<Locale> paramList)
  {
    AppMethodBeat.i(255237);
    if (paramList.isEmpty())
    {
      AppMethodBeat.o(255237);
      return null;
    }
    Object localObject3;
    Object localObject4;
    int i;
    Object localObject2;
    if (Build.VERSION.SDK_INT >= 26)
    {
      localObject3 = new ArrayList();
      localObject4 = this.context.getResources().getConfiguration().getLocales();
      int j = ((LocaleList)localObject4).size();
      i = 0;
      while (i < j)
      {
        Locale localLocale = ((LocaleList)localObject4).get(i);
        localObject2 = localLocale.getLanguage();
        localObject1 = localObject2;
        if (!localLocale.getScript().isEmpty()) {
          localObject1 = (String)localObject2 + "-" + localLocale.getScript();
        }
        localObject2 = localObject1;
        if (!localLocale.getCountry().isEmpty()) {
          localObject2 = (String)localObject1 + "-" + localLocale.getCountry();
        }
        ((List)localObject3).add(new Locale.LanguageRange((String)localObject2));
        ((List)localObject3).add(new Locale.LanguageRange(localLocale.getLanguage()));
        ((List)localObject3).add(new Locale.LanguageRange(localLocale.getLanguage() + "-*"));
        i += 1;
      }
      localObject1 = Locale.lookup((List)localObject3, paramList);
      if (localObject1 != null)
      {
        AppMethodBeat.o(255237);
        return localObject1;
      }
      paramList = (Locale)paramList.get(0);
      AppMethodBeat.o(255237);
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
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (Locale)((Iterator)localObject3).next();
          if (((Locale)localObject2).equals(localObject4))
          {
            AppMethodBeat.o(255237);
            return localObject4;
          }
        }
        localObject3 = paramList.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (Locale)((Iterator)localObject3).next();
          if (((Locale)localObject2).getLanguage().equals(((Locale)localObject4).toLanguageTag()))
          {
            AppMethodBeat.o(255237);
            return localObject4;
          }
        }
        localObject3 = paramList.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (Locale)((Iterator)localObject3).next();
          if (((Locale)localObject2).getLanguage().equals(((Locale)localObject4).getLanguage()))
          {
            AppMethodBeat.o(255237);
            return localObject4;
          }
        }
        i += 1;
      }
      paramList = (Locale)paramList.get(0);
      AppMethodBeat.o(255237);
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
          AppMethodBeat.o(255237);
          return localObject3;
        }
      }
      localObject2 = paramList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Locale)((Iterator)localObject2).next();
        if (((Locale)localObject1).getLanguage().equals(((Locale)localObject3).toString()))
        {
          AppMethodBeat.o(255237);
          return localObject3;
        }
      }
    }
    paramList = (Locale)paramList.get(0);
    AppMethodBeat.o(255237);
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.plugin.b.a
 * JD-Core Version:    0.7.0.1
 */