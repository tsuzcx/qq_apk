package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class gix
  extends com.tencent.mm.bx.a
{
  public String IcC;
  public String Md5;
  public String accA;
  public int acff;
  public int acfg;
  public String acfl;
  public gip acfm;
  public giw acfn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110863);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.acfl == null)
      {
        paramVarArgs = new b("Not all required fields were included: EntranceDomain");
        AppMethodBeat.o(110863);
        throw paramVarArgs;
      }
      if (this.accA == null)
      {
        paramVarArgs = new b("Not all required fields were included: Charset");
        AppMethodBeat.o(110863);
        throw paramVarArgs;
      }
      if (this.acfl != null) {
        paramVarArgs.g(4, this.acfl);
      }
      if (this.accA != null) {
        paramVarArgs.g(12, this.accA);
      }
      if (this.acfm != null)
      {
        paramVarArgs.qD(9, this.acfm.computeSize());
        this.acfm.writeFields(paramVarArgs);
      }
      if (this.acfn != null)
      {
        paramVarArgs.qD(10, this.acfn.computeSize());
        this.acfn.writeFields(paramVarArgs);
      }
      if (this.Md5 != null) {
        paramVarArgs.g(5, this.Md5);
      }
      if (this.IcC != null) {
        paramVarArgs.g(6, this.IcC);
      }
      paramVarArgs.bS(7, this.acff);
      paramVarArgs.bS(8, this.acfg);
      AppMethodBeat.o(110863);
      return 0;
    }
    if (paramInt == 1) {
      if (this.acfl == null) {
        break label858;
      }
    }
    label858:
    for (int i = i.a.a.b.b.a.h(4, this.acfl) + 0;; i = 0)
    {
      paramInt = i;
      if (this.accA != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.accA);
      }
      i = paramInt;
      if (this.acfm != null) {
        i = paramInt + i.a.a.a.qC(9, this.acfm.computeSize());
      }
      paramInt = i;
      if (this.acfn != null) {
        paramInt = i + i.a.a.a.qC(10, this.acfn.computeSize());
      }
      i = paramInt;
      if (this.Md5 != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.Md5);
      }
      paramInt = i;
      if (this.IcC != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.IcC);
      }
      i = i.a.a.b.b.a.cJ(7, this.acff);
      int j = i.a.a.b.b.a.cJ(8, this.acfg);
      AppMethodBeat.o(110863);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.acfl == null)
        {
          paramVarArgs = new b("Not all required fields were included: EntranceDomain");
          AppMethodBeat.o(110863);
          throw paramVarArgs;
        }
        if (this.accA == null)
        {
          paramVarArgs = new b("Not all required fields were included: Charset");
          AppMethodBeat.o(110863);
          throw paramVarArgs;
        }
        AppMethodBeat.o(110863);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        gix localgix = (gix)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 11: 
        default: 
          AppMethodBeat.o(110863);
          return -1;
        case 4: 
          localgix.acfl = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(110863);
          return 0;
        case 12: 
          localgix.accA = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(110863);
          return 0;
        case 9: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gip();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gip)localObject2).parseFrom((byte[])localObject1);
            }
            localgix.acfm = ((gip)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(110863);
          return 0;
        case 10: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new giw();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((giw)localObject2).parseFrom((byte[])localObject1);
            }
            localgix.acfn = ((giw)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(110863);
          return 0;
        case 5: 
          localgix.Md5 = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(110863);
          return 0;
        case 6: 
          localgix.IcC = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(110863);
          return 0;
        case 7: 
          localgix.acff = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(110863);
          return 0;
        }
        localgix.acfg = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(110863);
        return 0;
      }
      AppMethodBeat.o(110863);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gix
 * JD-Core Version:    0.7.0.1
 */