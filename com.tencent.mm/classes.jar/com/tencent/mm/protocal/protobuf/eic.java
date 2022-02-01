package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public class eic
  extends com.tencent.mm.bw.a
{
  public long DPz;
  public String ISo;
  public String Nhr;
  public String Nhs;
  public String hFF;
  public String md5;
  public int pCV = -1;
  public String pkK;
  public int reportId;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(224543);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.ISo == null)
      {
        paramVarArgs = new b("Not all required fields were included: initUrl");
        AppMethodBeat.o(224543);
        throw paramVarArgs;
      }
      if (this.Nhr == null)
      {
        paramVarArgs = new b("Not all required fields were included: initFilePath");
        AppMethodBeat.o(224543);
        throw paramVarArgs;
      }
      if (this.md5 == null)
      {
        paramVarArgs = new b("Not all required fields were included: md5");
        AppMethodBeat.o(224543);
        throw paramVarArgs;
      }
      if (this.hFF == null)
      {
        paramVarArgs = new b("Not all required fields were included: uid");
        AppMethodBeat.o(224543);
        throw paramVarArgs;
      }
      if (this.Nhs == null)
      {
        paramVarArgs = new b("Not all required fields were included: headers");
        AppMethodBeat.o(224543);
        throw paramVarArgs;
      }
      paramVarArgs.aM(1, this.pCV);
      paramVarArgs.aM(2, this.version);
      if (this.ISo != null) {
        paramVarArgs.e(3, this.ISo);
      }
      if (this.Nhr != null) {
        paramVarArgs.e(4, this.Nhr);
      }
      if (this.md5 != null) {
        paramVarArgs.e(5, this.md5);
      }
      if (this.hFF != null) {
        paramVarArgs.e(6, this.hFF);
      }
      if (this.Nhs != null) {
        paramVarArgs.e(7, this.Nhs);
      }
      paramVarArgs.bb(8, this.DPz);
      paramVarArgs.aM(9, this.reportId);
      if (this.pkK != null) {
        paramVarArgs.e(10, this.pkK);
      }
      AppMethodBeat.o(224543);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.pCV) + 0 + g.a.a.b.b.a.bu(2, this.version);
      paramInt = i;
      if (this.ISo != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.ISo);
      }
      i = paramInt;
      if (this.Nhr != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.Nhr);
      }
      paramInt = i;
      if (this.md5 != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.md5);
      }
      i = paramInt;
      if (this.hFF != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.hFF);
      }
      paramInt = i;
      if (this.Nhs != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.Nhs);
      }
      i = paramInt + g.a.a.b.b.a.r(8, this.DPz) + g.a.a.b.b.a.bu(9, this.reportId);
      paramInt = i;
      if (this.pkK != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.pkK);
      }
      AppMethodBeat.o(224543);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      if (this.ISo == null)
      {
        paramVarArgs = new b("Not all required fields were included: initUrl");
        AppMethodBeat.o(224543);
        throw paramVarArgs;
      }
      if (this.Nhr == null)
      {
        paramVarArgs = new b("Not all required fields were included: initFilePath");
        AppMethodBeat.o(224543);
        throw paramVarArgs;
      }
      if (this.md5 == null)
      {
        paramVarArgs = new b("Not all required fields were included: md5");
        AppMethodBeat.o(224543);
        throw paramVarArgs;
      }
      if (this.hFF == null)
      {
        paramVarArgs = new b("Not all required fields were included: uid");
        AppMethodBeat.o(224543);
        throw paramVarArgs;
      }
      if (this.Nhs == null)
      {
        paramVarArgs = new b("Not all required fields were included: headers");
        AppMethodBeat.o(224543);
        throw paramVarArgs;
      }
      AppMethodBeat.o(224543);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      eic localeic = (eic)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(224543);
        return -1;
      case 1: 
        localeic.pCV = locala.UbS.zi();
        AppMethodBeat.o(224543);
        return 0;
      case 2: 
        localeic.version = locala.UbS.zi();
        AppMethodBeat.o(224543);
        return 0;
      case 3: 
        localeic.ISo = locala.UbS.readString();
        AppMethodBeat.o(224543);
        return 0;
      case 4: 
        localeic.Nhr = locala.UbS.readString();
        AppMethodBeat.o(224543);
        return 0;
      case 5: 
        localeic.md5 = locala.UbS.readString();
        AppMethodBeat.o(224543);
        return 0;
      case 6: 
        localeic.hFF = locala.UbS.readString();
        AppMethodBeat.o(224543);
        return 0;
      case 7: 
        localeic.Nhs = locala.UbS.readString();
        AppMethodBeat.o(224543);
        return 0;
      case 8: 
        localeic.DPz = locala.UbS.zl();
        AppMethodBeat.o(224543);
        return 0;
      case 9: 
        localeic.reportId = locala.UbS.zi();
        AppMethodBeat.o(224543);
        return 0;
      }
      localeic.pkK = locala.UbS.readString();
      AppMethodBeat.o(224543);
      return 0;
    }
    AppMethodBeat.o(224543);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eic
 * JD-Core Version:    0.7.0.1
 */