package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class akx
  extends erp
{
  public long Njv;
  public int NkN;
  public int NkO;
  public int NkP;
  public String UserName;
  public int YHj;
  public String Zsf;
  public int Zsg;
  public int Zsh;
  public String oOI;
  public String oOL;
  public int vhJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(9590);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.oOI != null) {
        paramVarArgs.g(2, this.oOI);
      }
      paramVarArgs.bS(3, this.YHj);
      if (this.oOL != null) {
        paramVarArgs.g(4, this.oOL);
      }
      if (this.UserName != null) {
        paramVarArgs.g(5, this.UserName);
      }
      paramVarArgs.bS(6, this.NkN);
      paramVarArgs.bS(7, this.NkO);
      paramVarArgs.bS(8, this.NkP);
      if (this.Zsf != null) {
        paramVarArgs.g(9, this.Zsf);
      }
      paramVarArgs.bS(10, this.Zsg);
      paramVarArgs.bS(11, this.vhJ);
      paramVarArgs.bS(12, this.Zsh);
      paramVarArgs.bv(13, this.Njv);
      AppMethodBeat.o(9590);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label915;
      }
    }
    label915:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.oOI != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.oOI);
      }
      i += i.a.a.b.b.a.cJ(3, this.YHj);
      paramInt = i;
      if (this.oOL != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.oOL);
      }
      i = paramInt;
      if (this.UserName != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.UserName);
      }
      i = i + i.a.a.b.b.a.cJ(6, this.NkN) + i.a.a.b.b.a.cJ(7, this.NkO) + i.a.a.b.b.a.cJ(8, this.NkP);
      paramInt = i;
      if (this.Zsf != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.Zsf);
      }
      i = i.a.a.b.b.a.cJ(10, this.Zsg);
      int j = i.a.a.b.b.a.cJ(11, this.vhJ);
      int k = i.a.a.b.b.a.cJ(12, this.Zsh);
      int m = i.a.a.b.b.a.q(13, this.Njv);
      AppMethodBeat.o(9590);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(9590);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        akx localakx = (akx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(9590);
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
            localakx.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(9590);
          return 0;
        case 2: 
          localakx.oOI = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(9590);
          return 0;
        case 3: 
          localakx.YHj = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(9590);
          return 0;
        case 4: 
          localakx.oOL = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(9590);
          return 0;
        case 5: 
          localakx.UserName = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(9590);
          return 0;
        case 6: 
          localakx.NkN = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(9590);
          return 0;
        case 7: 
          localakx.NkO = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(9590);
          return 0;
        case 8: 
          localakx.NkP = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(9590);
          return 0;
        case 9: 
          localakx.Zsf = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(9590);
          return 0;
        case 10: 
          localakx.Zsg = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(9590);
          return 0;
        case 11: 
          localakx.vhJ = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(9590);
          return 0;
        case 12: 
          localakx.Zsh = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(9590);
          return 0;
        }
        localakx.Njv = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(9590);
        return 0;
      }
      AppMethodBeat.o(9590);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akx
 * JD-Core Version:    0.7.0.1
 */