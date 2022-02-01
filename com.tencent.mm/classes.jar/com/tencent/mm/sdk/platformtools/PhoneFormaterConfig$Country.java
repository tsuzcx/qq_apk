package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.List;

public class PhoneFormaterConfig$Country
{
  String countrycode;
  List<PhoneFormaterConfig.Format> formatList;
  String isocode;
  int maxlen;
  int minlen;
  
  public PhoneFormaterConfig$Country()
  {
    AppMethodBeat.i(157771);
    this.minlen = 10;
    this.maxlen = 20;
    this.formatList = new LinkedList();
    AppMethodBeat.o(157771);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.PhoneFormaterConfig.Country
 * JD-Core Version:    0.7.0.1
 */