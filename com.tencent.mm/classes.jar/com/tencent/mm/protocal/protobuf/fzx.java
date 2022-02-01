package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fzx
  extends erp
{
  public int ZkT;
  public String abXB;
  public com.tencent.mm.bx.b abXC;
  public com.tencent.mm.bx.b abXD;
  public String abXE;
  public long abmO;
  public int abmP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125498);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abXB == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: ToBizUserName");
        AppMethodBeat.o(125498);
        throw paramVarArgs;
      }
      if (this.abXD == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: CapInfo");
        AppMethodBeat.o(125498);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.abmP);
      if (this.abXB != null) {
        paramVarArgs.g(3, this.abXB);
      }
      paramVarArgs.bS(4, this.ZkT);
      if (this.abXC != null) {
        paramVarArgs.d(5, this.abXC);
      }
      if (this.abXD != null) {
        paramVarArgs.d(6, this.abXD);
      }
      paramVarArgs.bv(7, this.abmO);
      if (this.abXE != null) {
        paramVarArgs.g(8, this.abXE);
      }
      AppMethodBeat.o(125498);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label760;
      }
    }
    label760:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.abmP);
      paramInt = i;
      if (this.abXB != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.abXB);
      }
      i = paramInt + i.a.a.b.b.a.cJ(4, this.ZkT);
      paramInt = i;
      if (this.abXC != null) {
        paramInt = i + i.a.a.b.b.a.c(5, this.abXC);
      }
      i = paramInt;
      if (this.abXD != null) {
        i = paramInt + i.a.a.b.b.a.c(6, this.abXD);
      }
      i += i.a.a.b.b.a.q(7, this.abmO);
      paramInt = i;
      if (this.abXE != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.abXE);
      }
      AppMethodBeat.o(125498);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.abXB == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: ToBizUserName");
          AppMethodBeat.o(125498);
          throw paramVarArgs;
        }
        if (this.abXD == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: CapInfo");
          AppMethodBeat.o(125498);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125498);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fzx localfzx = (fzx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125498);
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
            localfzx.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(125498);
          return 0;
        case 2: 
          localfzx.abmP = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(125498);
          return 0;
        case 3: 
          localfzx.abXB = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(125498);
          return 0;
        case 4: 
          localfzx.ZkT = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(125498);
          return 0;
        case 5: 
          localfzx.abXC = ((i.a.a.a.a)localObject).ajGk.kFX();
          AppMethodBeat.o(125498);
          return 0;
        case 6: 
          localfzx.abXD = ((i.a.a.a.a)localObject).ajGk.kFX();
          AppMethodBeat.o(125498);
          return 0;
        case 7: 
          localfzx.abmO = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(125498);
          return 0;
        }
        localfzx.abXE = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(125498);
        return 0;
      }
      AppMethodBeat.o(125498);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fzx
 * JD-Core Version:    0.7.0.1
 */