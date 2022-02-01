package com.tencent.xweb.util;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
{
  public static String bHY(String paramString)
  {
    AppMethodBeat.i(212590);
    StringBuilder localStringBuilder = new StringBuilder(2000);
    localStringBuilder.append("<html>\n");
    localStringBuilder.append("<head>\n");
    localStringBuilder.append("<script type=\"text/javascript\">\n");
    localStringBuilder.append("function jumurl(){\n");
    localStringBuilder.append("　　window.location.href = '");
    localStringBuilder.append(paramString);
    localStringBuilder.append("';\n");
    localStringBuilder.append("}\n");
    localStringBuilder.append("</script>\n");
    localStringBuilder.append("<title>无法打开页面</title>\n");
    localStringBuilder.append("<script >\n");
    localStringBuilder.append("var html = document.documentElement,");
    localStringBuilder.append("resizeEvt = 'orientationchange' in window ? 'orientationchange' : 'resize';");
    localStringBuilder.append("function setHtmlFontSize() {");
    localStringBuilder.append("var cliWidth = html.clientWidth;");
    localStringBuilder.append("html.style.fontSize = 100 * (cliWidth / 720) + 'px';}");
    localStringBuilder.append("window.addEventListener(resizeEvt, setHtmlFontSize, false);");
    localStringBuilder.append("</script>\n");
    localStringBuilder.append("<style>.exp{ text-align:center; margin-top:15rem; height=\"10rem\" width=\"10rem\"}</style>\n");
    localStringBuilder.append("<style>.fcolorfortitle{ color: rgba(0, 0, 0, 0.3); font-size:44px;}</style>\n");
    localStringBuilder.append("<style>.fcolorforsubtitle{ color: rgba(0, 0, 0, 0.3); font-size:34px;}</style>\n");
    localStringBuilder.append("</head>\n");
    localStringBuilder.append("<body bgcolor=\"#F2F2F2\" onclick=\"jumurl()\"'\">\n");
    localStringBuilder.append("<br></br>");
    localStringBuilder.append("<p></p>");
    localStringBuilder.append("<div class=\"exp\" ><img src=\"html/img/webview_404_refresh_icon.svg\" text-align:center /><div>");
    localStringBuilder.append("<br></br>");
    localStringBuilder.append("<font size=\"44px\" class=\"fcolorfortitle\">无法打开页面</font>");
    localStringBuilder.append("<br></br>");
    localStringBuilder.append("<font size=\"44px\" class=\"fcolorforsubtitle\">轻触屏幕重新加载</font>");
    localStringBuilder.append("</body>\n");
    localStringBuilder.append("</html>");
    paramString = localStringBuilder.toString();
    AppMethodBeat.o(212590);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.xweb.util.f
 * JD-Core Version:    0.7.0.1
 */