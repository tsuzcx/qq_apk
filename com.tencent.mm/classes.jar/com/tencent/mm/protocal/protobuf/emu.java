package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class emu
  extends esc
{
  public int Kmo;
  public int Kmp;
  public String Kmq;
  public com.tencent.mm.bx.b abdC;
  public int abdD;
  public int abdE;
  public String abdI;
  public String abdJ;
  public String abdK;
  public int abdL;
  public String abdN;
  public String lym;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91662);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91662);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.abdD);
      if (this.Kmq != null) {
        paramVarArgs.g(3, this.Kmq);
      }
      if (this.abdJ != null) {
        paramVarArgs.g(4, this.abdJ);
      }
      if (this.abdK != null) {
        paramVarArgs.g(5, this.abdK);
      }
      if (this.abdC != null) {
        paramVarArgs.d(6, this.abdC);
      }
      paramVarArgs.bS(7, this.abdE);
      paramVarArgs.bS(8, this.Kmo);
      paramVarArgs.bS(9, this.abdL);
      paramVarArgs.bS(10, this.Kmp);
      if (this.lym != null) {
        paramVarArgs.g(11, this.lym);
      }
      if (this.abdN != null) {
        paramVarArgs.g(12, this.abdN);
      }
      if (this.abdI != null) {
        paramVarArgs.g(13, this.abdI);
      }
      AppMethodBeat.o(91662);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label984;
      }
    }
    label984:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.abdD);
      paramInt = i;
      if (this.Kmq != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.Kmq);
      }
      i = paramInt;
      if (this.abdJ != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.abdJ);
      }
      paramInt = i;
      if (this.abdK != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.abdK);
      }
      i = paramInt;
      if (this.abdC != null) {
        i = paramInt + i.a.a.b.b.a.c(6, this.abdC);
      }
      i = i + i.a.a.b.b.a.cJ(7, this.abdE) + i.a.a.b.b.a.cJ(8, this.Kmo) + i.a.a.b.b.a.cJ(9, this.abdL) + i.a.a.b.b.a.cJ(10, this.Kmp);
      paramInt = i;
      if (this.lym != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.lym);
      }
      i = paramInt;
      if (this.abdN != null) {
        i = paramInt + i.a.a.b.b.a.h(12, this.abdN);
      }
      paramInt = i;
      if (this.abdI != null) {
        paramInt = i + i.a.a.b.b.a.h(13, this.abdI);
      }
      AppMethodBeat.o(91662);
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
          paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91662);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91662);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        emu localemu = (emu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91662);
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
            localemu.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(91662);
          return 0;
        case 2: 
          localemu.abdD = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91662);
          return 0;
        case 3: 
          localemu.Kmq = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91662);
          return 0;
        case 4: 
          localemu.abdJ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91662);
          return 0;
        case 5: 
          localemu.abdK = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91662);
          return 0;
        case 6: 
          localemu.abdC = ((i.a.a.a.a)localObject).ajGk.kFX();
          AppMethodBeat.o(91662);
          return 0;
        case 7: 
          localemu.abdE = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91662);
          return 0;
        case 8: 
          localemu.Kmo = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91662);
          return 0;
        case 9: 
          localemu.abdL = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91662);
          return 0;
        case 10: 
          localemu.Kmp = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91662);
          return 0;
        case 11: 
          localemu.lym = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91662);
          return 0;
        case 12: 
          localemu.abdN = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91662);
          return 0;
        }
        localemu.abdI = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(91662);
        return 0;
      }
      AppMethodBeat.o(91662);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.emu
 * JD-Core Version:    0.7.0.1
 */