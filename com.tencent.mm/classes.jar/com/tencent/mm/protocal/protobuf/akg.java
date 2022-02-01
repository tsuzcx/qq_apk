package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class akg
  extends com.tencent.mm.cd.a
{
  public int RIs;
  public String Sva;
  public String Svb;
  public String Svc;
  public String Svd;
  public String Sve;
  public int Svf;
  public int Svg;
  public String Svh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104780);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Sva == null)
      {
        paramVarArgs = new b("Not all required fields were included: BegWord");
        AppMethodBeat.o(104780);
        throw paramVarArgs;
      }
      if (this.Svb == null)
      {
        paramVarArgs = new b("Not all required fields were included: BegPicUrl");
        AppMethodBeat.o(104780);
        throw paramVarArgs;
      }
      if (this.Svc == null)
      {
        paramVarArgs = new b("Not all required fields were included: ThanksPicUrl");
        AppMethodBeat.o(104780);
        throw paramVarArgs;
      }
      if (this.Sva != null) {
        paramVarArgs.f(1, this.Sva);
      }
      if (this.Svb != null) {
        paramVarArgs.f(2, this.Svb);
      }
      if (this.Svc != null) {
        paramVarArgs.f(3, this.Svc);
      }
      if (this.Svd != null) {
        paramVarArgs.f(4, this.Svd);
      }
      if (this.Sve != null) {
        paramVarArgs.f(5, this.Sve);
      }
      paramVarArgs.aY(6, this.Svf);
      paramVarArgs.aY(7, this.Svg);
      if (this.Svh != null) {
        paramVarArgs.f(8, this.Svh);
      }
      paramVarArgs.aY(9, this.RIs);
      AppMethodBeat.o(104780);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Sva == null) {
        break label798;
      }
    }
    label798:
    for (int i = g.a.a.b.b.a.g(1, this.Sva) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Svb != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Svb);
      }
      i = paramInt;
      if (this.Svc != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Svc);
      }
      paramInt = i;
      if (this.Svd != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Svd);
      }
      i = paramInt;
      if (this.Sve != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.Sve);
      }
      i = i + g.a.a.b.b.a.bM(6, this.Svf) + g.a.a.b.b.a.bM(7, this.Svg);
      paramInt = i;
      if (this.Svh != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.Svh);
      }
      i = g.a.a.b.b.a.bM(9, this.RIs);
      AppMethodBeat.o(104780);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.Sva == null)
        {
          paramVarArgs = new b("Not all required fields were included: BegWord");
          AppMethodBeat.o(104780);
          throw paramVarArgs;
        }
        if (this.Svb == null)
        {
          paramVarArgs = new b("Not all required fields were included: BegPicUrl");
          AppMethodBeat.o(104780);
          throw paramVarArgs;
        }
        if (this.Svc == null)
        {
          paramVarArgs = new b("Not all required fields were included: ThanksPicUrl");
          AppMethodBeat.o(104780);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104780);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        akg localakg = (akg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104780);
          return -1;
        case 1: 
          localakg.Sva = locala.abFh.readString();
          AppMethodBeat.o(104780);
          return 0;
        case 2: 
          localakg.Svb = locala.abFh.readString();
          AppMethodBeat.o(104780);
          return 0;
        case 3: 
          localakg.Svc = locala.abFh.readString();
          AppMethodBeat.o(104780);
          return 0;
        case 4: 
          localakg.Svd = locala.abFh.readString();
          AppMethodBeat.o(104780);
          return 0;
        case 5: 
          localakg.Sve = locala.abFh.readString();
          AppMethodBeat.o(104780);
          return 0;
        case 6: 
          localakg.Svf = locala.abFh.AK();
          AppMethodBeat.o(104780);
          return 0;
        case 7: 
          localakg.Svg = locala.abFh.AK();
          AppMethodBeat.o(104780);
          return 0;
        case 8: 
          localakg.Svh = locala.abFh.readString();
          AppMethodBeat.o(104780);
          return 0;
        }
        localakg.RIs = locala.abFh.AK();
        AppMethodBeat.o(104780);
        return 0;
      }
      AppMethodBeat.o(104780);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akg
 * JD-Core Version:    0.7.0.1
 */