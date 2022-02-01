package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class erv
  extends com.tencent.mm.cd.a
{
  public String DNx;
  public String DNy;
  public String DaW;
  public String UtP;
  public String UtQ;
  public int UtR;
  public String coY;
  public String msg;
  public String patchMd5;
  public int qLX;
  public String smT;
  public String title;
  public int versionCode;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123719);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.coY == null)
      {
        paramVarArgs = new b("Not all required fields were included: patchId");
        AppMethodBeat.o(123719);
        throw paramVarArgs;
      }
      if (this.DNx == null)
      {
        paramVarArgs = new b("Not all required fields were included: newApkMd5");
        AppMethodBeat.o(123719);
        throw paramVarArgs;
      }
      if (this.DNy == null)
      {
        paramVarArgs = new b("Not all required fields were included: oldApkMd5");
        AppMethodBeat.o(123719);
        throw paramVarArgs;
      }
      if (this.title == null)
      {
        paramVarArgs = new b("Not all required fields were included: title");
        AppMethodBeat.o(123719);
        throw paramVarArgs;
      }
      if (this.UtQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: okBtn");
        AppMethodBeat.o(123719);
        throw paramVarArgs;
      }
      if (this.DaW == null)
      {
        paramVarArgs = new b("Not all required fields were included: cancelBtn");
        AppMethodBeat.o(123719);
        throw paramVarArgs;
      }
      if (this.patchMd5 == null)
      {
        paramVarArgs = new b("Not all required fields were included: patchMd5");
        AppMethodBeat.o(123719);
        throw paramVarArgs;
      }
      if (this.coY != null) {
        paramVarArgs.f(1, this.coY);
      }
      if (this.UtP != null) {
        paramVarArgs.f(2, this.UtP);
      }
      paramVarArgs.aY(3, this.qLX);
      if (this.DNx != null) {
        paramVarArgs.f(4, this.DNx);
      }
      if (this.DNy != null) {
        paramVarArgs.f(5, this.DNy);
      }
      if (this.title != null) {
        paramVarArgs.f(6, this.title);
      }
      if (this.msg != null) {
        paramVarArgs.f(7, this.msg);
      }
      if (this.UtQ != null) {
        paramVarArgs.f(8, this.UtQ);
      }
      if (this.DaW != null) {
        paramVarArgs.f(9, this.DaW);
      }
      if (this.smT != null) {
        paramVarArgs.f(10, this.smT);
      }
      if (this.patchMd5 != null) {
        paramVarArgs.f(11, this.patchMd5);
      }
      paramVarArgs.aY(12, this.versionCode);
      paramVarArgs.aY(13, this.UtR);
      AppMethodBeat.o(123719);
      return 0;
    }
    if (paramInt == 1) {
      if (this.coY == null) {
        break label1242;
      }
    }
    label1242:
    for (paramInt = g.a.a.b.b.a.g(1, this.coY) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.UtP != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.UtP);
      }
      i += g.a.a.b.b.a.bM(3, this.qLX);
      paramInt = i;
      if (this.DNx != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.DNx);
      }
      i = paramInt;
      if (this.DNy != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.DNy);
      }
      paramInt = i;
      if (this.title != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.title);
      }
      i = paramInt;
      if (this.msg != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.msg);
      }
      paramInt = i;
      if (this.UtQ != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.UtQ);
      }
      i = paramInt;
      if (this.DaW != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.DaW);
      }
      paramInt = i;
      if (this.smT != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.smT);
      }
      i = paramInt;
      if (this.patchMd5 != null) {
        i = paramInt + g.a.a.b.b.a.g(11, this.patchMd5);
      }
      paramInt = g.a.a.b.b.a.bM(12, this.versionCode);
      int j = g.a.a.b.b.a.bM(13, this.UtR);
      AppMethodBeat.o(123719);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.coY == null)
        {
          paramVarArgs = new b("Not all required fields were included: patchId");
          AppMethodBeat.o(123719);
          throw paramVarArgs;
        }
        if (this.DNx == null)
        {
          paramVarArgs = new b("Not all required fields were included: newApkMd5");
          AppMethodBeat.o(123719);
          throw paramVarArgs;
        }
        if (this.DNy == null)
        {
          paramVarArgs = new b("Not all required fields were included: oldApkMd5");
          AppMethodBeat.o(123719);
          throw paramVarArgs;
        }
        if (this.title == null)
        {
          paramVarArgs = new b("Not all required fields were included: title");
          AppMethodBeat.o(123719);
          throw paramVarArgs;
        }
        if (this.UtQ == null)
        {
          paramVarArgs = new b("Not all required fields were included: okBtn");
          AppMethodBeat.o(123719);
          throw paramVarArgs;
        }
        if (this.DaW == null)
        {
          paramVarArgs = new b("Not all required fields were included: cancelBtn");
          AppMethodBeat.o(123719);
          throw paramVarArgs;
        }
        if (this.patchMd5 == null)
        {
          paramVarArgs = new b("Not all required fields were included: patchMd5");
          AppMethodBeat.o(123719);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123719);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        erv localerv = (erv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123719);
          return -1;
        case 1: 
          localerv.coY = locala.abFh.readString();
          AppMethodBeat.o(123719);
          return 0;
        case 2: 
          localerv.UtP = locala.abFh.readString();
          AppMethodBeat.o(123719);
          return 0;
        case 3: 
          localerv.qLX = locala.abFh.AK();
          AppMethodBeat.o(123719);
          return 0;
        case 4: 
          localerv.DNx = locala.abFh.readString();
          AppMethodBeat.o(123719);
          return 0;
        case 5: 
          localerv.DNy = locala.abFh.readString();
          AppMethodBeat.o(123719);
          return 0;
        case 6: 
          localerv.title = locala.abFh.readString();
          AppMethodBeat.o(123719);
          return 0;
        case 7: 
          localerv.msg = locala.abFh.readString();
          AppMethodBeat.o(123719);
          return 0;
        case 8: 
          localerv.UtQ = locala.abFh.readString();
          AppMethodBeat.o(123719);
          return 0;
        case 9: 
          localerv.DaW = locala.abFh.readString();
          AppMethodBeat.o(123719);
          return 0;
        case 10: 
          localerv.smT = locala.abFh.readString();
          AppMethodBeat.o(123719);
          return 0;
        case 11: 
          localerv.patchMd5 = locala.abFh.readString();
          AppMethodBeat.o(123719);
          return 0;
        case 12: 
          localerv.versionCode = locala.abFh.AK();
          AppMethodBeat.o(123719);
          return 0;
        }
        localerv.UtR = locala.abFh.AK();
        AppMethodBeat.o(123719);
        return 0;
      }
      AppMethodBeat.o(123719);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.erv
 * JD-Core Version:    0.7.0.1
 */