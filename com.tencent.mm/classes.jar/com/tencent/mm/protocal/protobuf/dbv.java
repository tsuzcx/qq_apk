package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public class dbv
  extends com.tencent.mm.bv.a
{
  public String IconUrl;
  public String fKw;
  public String jJA;
  public String nrg;
  public String ntp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(93819);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.fKw == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppId");
        AppMethodBeat.o(93819);
        throw paramVarArgs;
      }
      if (this.ntp == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppName");
        AppMethodBeat.o(93819);
        throw paramVarArgs;
      }
      if (this.jJA == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(93819);
        throw paramVarArgs;
      }
      if (this.IconUrl == null)
      {
        paramVarArgs = new b("Not all required fields were included: IconUrl");
        AppMethodBeat.o(93819);
        throw paramVarArgs;
      }
      if (this.fKw != null) {
        paramVarArgs.e(1, this.fKw);
      }
      if (this.ntp != null) {
        paramVarArgs.e(2, this.ntp);
      }
      if (this.jJA != null) {
        paramVarArgs.e(3, this.jJA);
      }
      if (this.IconUrl != null) {
        paramVarArgs.e(4, this.IconUrl);
      }
      if (this.nrg != null) {
        paramVarArgs.e(5, this.nrg);
      }
      AppMethodBeat.o(93819);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fKw == null) {
        break label646;
      }
    }
    label646:
    for (int i = e.a.a.b.b.a.f(1, this.fKw) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ntp != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.ntp);
      }
      i = paramInt;
      if (this.jJA != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.jJA);
      }
      paramInt = i;
      if (this.IconUrl != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.IconUrl);
      }
      i = paramInt;
      if (this.nrg != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.nrg);
      }
      AppMethodBeat.o(93819);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.fKw == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppId");
          AppMethodBeat.o(93819);
          throw paramVarArgs;
        }
        if (this.ntp == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppName");
          AppMethodBeat.o(93819);
          throw paramVarArgs;
        }
        if (this.jJA == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(93819);
          throw paramVarArgs;
        }
        if (this.IconUrl == null)
        {
          paramVarArgs = new b("Not all required fields were included: IconUrl");
          AppMethodBeat.o(93819);
          throw paramVarArgs;
        }
        AppMethodBeat.o(93819);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        dbv localdbv = (dbv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(93819);
          return -1;
        case 1: 
          localdbv.fKw = locala.CLY.readString();
          AppMethodBeat.o(93819);
          return 0;
        case 2: 
          localdbv.ntp = locala.CLY.readString();
          AppMethodBeat.o(93819);
          return 0;
        case 3: 
          localdbv.jJA = locala.CLY.readString();
          AppMethodBeat.o(93819);
          return 0;
        case 4: 
          localdbv.IconUrl = locala.CLY.readString();
          AppMethodBeat.o(93819);
          return 0;
        }
        localdbv.nrg = locala.CLY.readString();
        AppMethodBeat.o(93819);
        return 0;
      }
      AppMethodBeat.o(93819);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbv
 * JD-Core Version:    0.7.0.1
 */