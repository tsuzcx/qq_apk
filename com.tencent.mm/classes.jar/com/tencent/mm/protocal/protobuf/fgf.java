package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fgf
  extends erp
{
  public int IJG;
  public int IcB;
  public String Username;
  public String abDu;
  public long abDv;
  public long abEV;
  public int abEW;
  public int abFH;
  public int abFb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257947);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.abDu != null) {
        paramVarArgs.g(2, this.abDu);
      }
      if (this.Username != null) {
        paramVarArgs.g(3, this.Username);
      }
      paramVarArgs.bv(4, this.abDv);
      paramVarArgs.bS(5, this.IcB);
      paramVarArgs.bv(6, this.abEV);
      paramVarArgs.bS(7, this.abEW);
      paramVarArgs.bS(8, this.abFH);
      paramVarArgs.bS(9, this.abFb);
      paramVarArgs.bS(10, this.IJG);
      AppMethodBeat.o(257947);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label736;
      }
    }
    label736:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.abDu != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.abDu);
      }
      i = paramInt;
      if (this.Username != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.Username);
      }
      paramInt = i.a.a.b.b.a.q(4, this.abDv);
      int j = i.a.a.b.b.a.cJ(5, this.IcB);
      int k = i.a.a.b.b.a.q(6, this.abEV);
      int m = i.a.a.b.b.a.cJ(7, this.abEW);
      int n = i.a.a.b.b.a.cJ(8, this.abFH);
      int i1 = i.a.a.b.b.a.cJ(9, this.abFb);
      int i2 = i.a.a.b.b.a.cJ(10, this.IJG);
      AppMethodBeat.o(257947);
      return i + paramInt + j + k + m + n + i1 + i2;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257947);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fgf localfgf = (fgf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257947);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kc localkc = new kc();
            if ((localObject != null) && (localObject.length > 0)) {
              localkc.parseFrom((byte[])localObject);
            }
            localfgf.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(257947);
          return 0;
        case 2: 
          localfgf.abDu = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257947);
          return 0;
        case 3: 
          localfgf.Username = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257947);
          return 0;
        case 4: 
          localfgf.abDv = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(257947);
          return 0;
        case 5: 
          localfgf.IcB = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(257947);
          return 0;
        case 6: 
          localfgf.abEV = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(257947);
          return 0;
        case 7: 
          localfgf.abEW = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(257947);
          return 0;
        case 8: 
          localfgf.abFH = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(257947);
          return 0;
        case 9: 
          localfgf.abFb = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(257947);
          return 0;
        }
        localfgf.IJG = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(257947);
        return 0;
      }
      AppMethodBeat.o(257947);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fgf
 * JD-Core Version:    0.7.0.1
 */