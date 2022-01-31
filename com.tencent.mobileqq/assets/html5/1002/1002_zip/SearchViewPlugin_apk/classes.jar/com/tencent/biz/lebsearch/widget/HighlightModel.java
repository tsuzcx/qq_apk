package com.tencent.biz.lebsearch.widget;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

public class HighlightModel
{
  public List<String> words;
  
  public HighlightModel(List<String> paramList)
  {
    this.words = paramList;
  }
  
  public HighlightModel(List<String> paramList, String paramString)
  {
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    if ((paramString != null) && (!((List)localObject).contains(paramString))) {
      ((List)localObject).add(paramString);
    }
    Collections.sort((List)localObject, new Comparator()
    {
      public int compare(String paramAnonymousString1, String paramAnonymousString2)
      {
        if ((paramAnonymousString1 == null) || (paramAnonymousString2 == null)) {
          return 0;
        }
        return paramAnonymousString2.length() - paramAnonymousString1.length();
      }
    });
    this.words = ((List)localObject);
  }
  
  public HighlightModel(JSONArray paramJSONArray)
  {
    this(paramJSONArray, null);
  }
  
  public HighlightModel(JSONArray paramJSONArray, String paramString)
  {
    JSONArray localJSONArray = paramJSONArray;
    if (paramJSONArray == null) {
      localJSONArray = new JSONArray();
    }
    try
    {
      int j = localJSONArray.length();
      paramJSONArray = new ArrayList();
      int i = 0;
      while (i < j)
      {
        paramJSONArray.add(localJSONArray.getString(i));
        i += 1;
      }
      if (!paramJSONArray.contains(paramString)) {
        paramJSONArray.add(paramString);
      }
      Collections.sort(paramJSONArray, new Comparator()
      {
        public int compare(String paramAnonymousString1, String paramAnonymousString2)
        {
          if ((paramAnonymousString1 == null) || (paramAnonymousString2 == null)) {
            return 0;
          }
          return paramAnonymousString2.length() - paramAnonymousString1.length();
        }
      });
      this.words = paramJSONArray;
      return;
    }
    catch (JSONException paramJSONArray)
    {
      paramJSONArray.printStackTrace();
    }
  }
  
  public SpannableString getHighlightWords(String paramString)
  {
    return getHighlightWords(paramString, false);
  }
  
  public SpannableString getHighlightWords(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      localObject1 = null;
    }
    Object localObject3;
    int i;
    int m;
    int k;
    String str;
    do
    {
      Object[] arrayOfObject;
      do
      {
        do
        {
          do
          {
            return localObject1;
            localObject3 = new SpannableString(paramString);
            localObject1 = localObject3;
          } while (this.words == null);
          localObject1 = localObject3;
        } while (this.words.size() <= 0);
        i = 0;
        m = 0;
        arrayOfObject = this.words.toArray();
        k = 0;
        localObject2 = paramString;
        paramString = (String)localObject3;
        localObject1 = paramString;
      } while (k >= arrayOfObject.length);
      str = (String)arrayOfObject[k];
      if (str.length() > 1) {
        break;
      }
      localObject1 = paramString;
    } while (m != 0);
    int j = 0;
    Object localObject1 = localObject2;
    Object localObject2 = paramString;
    for (;;)
    {
      int i1 = indexOfIgnoreCase((String)localObject1, str, j);
      if (i1 == -1)
      {
        k += 1;
        paramString = (String)localObject2;
        localObject2 = localObject1;
        break;
      }
      int n = i1;
      j = i;
      localObject3 = localObject2;
      paramString = (String)localObject1;
      if (i1 > 10)
      {
        n = i1;
        j = i;
        localObject3 = localObject2;
        paramString = (String)localObject1;
        if (i == 0)
        {
          n = i1;
          j = i;
          localObject3 = localObject2;
          paramString = (String)localObject1;
          if (!paramBoolean)
          {
            paramString = "…" + ((String)localObject1).substring(i1 - 6);
            n = 7;
            localObject3 = new SpannableString(paramString);
            j = 1;
          }
        }
      }
      i = j;
      if (str.length() > 1)
      {
        m = 1;
        i = 1;
      }
      ((SpannableString)localObject3).setSpan(new ForegroundColorSpan(Color.parseColor("#00a5e0")), n, str.length() + n, 34);
      j = n + 1;
      localObject2 = localObject3;
      localObject1 = paramString;
    }
  }
  
  public int indexOfIgnoreCase(String paramString1, String paramString2, int paramInt)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return -1;
    }
    return paramString1.toLowerCase().indexOf(paramString2.toLowerCase(), paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\assets\html5\1002\1002_zip\SearchViewPlugin_apk\classes.jar
 * Qualified Name:     com.tencent.biz.lebsearch.widget.HighlightModel
 * JD-Core Version:    0.7.0.1
 */