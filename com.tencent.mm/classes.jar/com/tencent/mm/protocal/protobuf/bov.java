package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bov
  extends esc
{
  public int ZSf;
  public int ZSg;
  public int ZXk;
  public int ZXl;
  public int ZXm;
  public int ZXn;
  public int ZXo;
  public int akkO;
  public long akkP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258348);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.ZXk);
      paramVarArgs.bS(3, this.ZXl);
      paramVarArgs.bS(4, this.ZXm);
      paramVarArgs.bS(5, this.ZXn);
      paramVarArgs.bS(6, this.ZSf);
      paramVarArgs.bS(7, this.ZSg);
      paramVarArgs.bS(8, this.ZXo);
      paramVarArgs.bS(9, this.akkO);
      paramVarArgs.bv(10, this.akkP);
      AppMethodBeat.o(258348);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label708;
      }
    }
    label708:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.ZXk);
      int j = i.a.a.b.b.a.cJ(3, this.ZXl);
      int k = i.a.a.b.b.a.cJ(4, this.ZXm);
      int m = i.a.a.b.b.a.cJ(5, this.ZXn);
      int n = i.a.a.b.b.a.cJ(6, this.ZSf);
      int i1 = i.a.a.b.b.a.cJ(7, this.ZSg);
      int i2 = i.a.a.b.b.a.cJ(8, this.ZXo);
      int i3 = i.a.a.b.b.a.cJ(9, this.akkO);
      int i4 = i.a.a.b.b.a.q(10, this.akkP);
      AppMethodBeat.o(258348);
      return paramInt + i + j + k + m + n + i1 + i2 + i3 + i4;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258348);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        bov localbov = (bov)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258348);
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
            localbov.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(258348);
          return 0;
        case 2: 
          localbov.ZXk = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258348);
          return 0;
        case 3: 
          localbov.ZXl = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258348);
          return 0;
        case 4: 
          localbov.ZXm = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258348);
          return 0;
        case 5: 
          localbov.ZXn = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258348);
          return 0;
        case 6: 
          localbov.ZSf = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258348);
          return 0;
        case 7: 
          localbov.ZSg = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258348);
          return 0;
        case 8: 
          localbov.ZXo = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258348);
          return 0;
        case 9: 
          localbov.akkO = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258348);
          return 0;
        }
        localbov.akkP = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(258348);
        return 0;
      }
      AppMethodBeat.o(258348);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bov
 * JD-Core Version:    0.7.0.1
 */