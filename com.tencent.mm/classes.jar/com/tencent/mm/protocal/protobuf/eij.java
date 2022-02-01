package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class eij
  extends esc
{
  public int JGZ;
  public String JHa;
  public int JHo;
  public long ZvA;
  public int Zvz;
  public int abnm;
  public int abno;
  public int abnp;
  public int ytv;
  public String ytw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32391);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32391);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(3, this.Zvz);
      paramVarArgs.bv(4, this.ZvA);
      paramVarArgs.bS(5, this.abno);
      paramVarArgs.bS(6, this.abnm);
      paramVarArgs.bS(7, this.JHo);
      paramVarArgs.bS(8, this.abnp);
      paramVarArgs.bS(9, this.ytv);
      if (this.ytw != null) {
        paramVarArgs.g(10, this.ytw);
      }
      paramVarArgs.bS(11, this.JGZ);
      if (this.JHa != null) {
        paramVarArgs.g(12, this.JHa);
      }
      AppMethodBeat.o(32391);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label829;
      }
    }
    label829:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(3, this.Zvz) + i.a.a.b.b.a.q(4, this.ZvA) + i.a.a.b.b.a.cJ(5, this.abno) + i.a.a.b.b.a.cJ(6, this.abnm) + i.a.a.b.b.a.cJ(7, this.JHo) + i.a.a.b.b.a.cJ(8, this.abnp) + i.a.a.b.b.a.cJ(9, this.ytv);
      paramInt = i;
      if (this.ytw != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.ytw);
      }
      i = paramInt + i.a.a.b.b.a.cJ(11, this.JGZ);
      paramInt = i;
      if (this.JHa != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.JHa);
      }
      AppMethodBeat.o(32391);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32391);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32391);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        eij localeij = (eij)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 2: 
        default: 
          AppMethodBeat.o(32391);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kd localkd = new kd();
            if ((localObject != null) && (localObject.length > 0)) {
              localkd.parseFrom((byte[])localObject);
            }
            localeij.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(32391);
          return 0;
        case 3: 
          localeij.Zvz = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(32391);
          return 0;
        case 4: 
          localeij.ZvA = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(32391);
          return 0;
        case 5: 
          localeij.abno = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(32391);
          return 0;
        case 6: 
          localeij.abnm = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(32391);
          return 0;
        case 7: 
          localeij.JHo = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(32391);
          return 0;
        case 8: 
          localeij.abnp = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(32391);
          return 0;
        case 9: 
          localeij.ytv = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(32391);
          return 0;
        case 10: 
          localeij.ytw = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32391);
          return 0;
        case 11: 
          localeij.JGZ = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(32391);
          return 0;
        }
        localeij.JHa = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(32391);
        return 0;
      }
      AppMethodBeat.o(32391);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eij
 * JD-Core Version:    0.7.0.1
 */