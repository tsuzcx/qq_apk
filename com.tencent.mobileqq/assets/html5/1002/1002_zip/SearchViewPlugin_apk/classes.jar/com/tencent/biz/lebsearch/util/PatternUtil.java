package com.tencent.biz.lebsearch.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternUtil
{
  public static String getStrRemoveSpace(String paramString)
  {
    return Pattern.compile("[\\s|\\t|\\r|\\n]+").matcher(paramString).replaceAll("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\assets\html5\1002\1002_zip\SearchViewPlugin_apk\classes.jar
 * Qualified Name:     com.tencent.biz.lebsearch.util.PatternUtil
 * JD-Core Version:    0.7.0.1
 */