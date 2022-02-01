package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ehz
  extends erp
{
  public String IMg;
  public String IMh;
  public int ZkT;
  public long abmO;
  public int abmP;
  public String abmQ;
  public int abmX;
  public int abmY;
  public int abmZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32378);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.IMh != null) {
        paramVarArgs.g(2, this.IMh);
      }
      if (this.abmQ != null) {
        paramVarArgs.g(3, this.abmQ);
      }
      paramVarArgs.bS(4, this.ZkT);
      paramVarArgs.bv(5, this.abmO);
      paramVarArgs.bS(6, this.abmP);
      if (this.IMg != null) {
        paramVarArgs.g(7, this.IMg);
      }
      paramVarArgs.bS(8, this.abmY);
      paramVarArgs.bS(9, this.abmX);
      paramVarArgs.bS(10, this.abmZ);
      AppMethodBeat.o(32378);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label756;
      }
    }
    label756:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IMh != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.IMh);
      }
      i = paramInt;
      if (this.abmQ != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.abmQ);
      }
      i = i + i.a.a.b.b.a.cJ(4, this.ZkT) + i.a.a.b.b.a.q(5, this.abmO) + i.a.a.b.b.a.cJ(6, this.abmP);
      paramInt = i;
      if (this.IMg != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.IMg);
      }
      i = i.a.a.b.b.a.cJ(8, this.abmY);
      int j = i.a.a.b.b.a.cJ(9, this.abmX);
      int k = i.a.a.b.b.a.cJ(10, this.abmZ);
      AppMethodBeat.o(32378);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(32378);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ehz localehz = (ehz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32378);
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
            localehz.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(32378);
          return 0;
        case 2: 
          localehz.IMh = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32378);
          return 0;
        case 3: 
          localehz.abmQ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32378);
          return 0;
        case 4: 
          localehz.ZkT = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(32378);
          return 0;
        case 5: 
          localehz.abmO = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(32378);
          return 0;
        case 6: 
          localehz.abmP = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(32378);
          return 0;
        case 7: 
          localehz.IMg = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32378);
          return 0;
        case 8: 
          localehz.abmY = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(32378);
          return 0;
        case 9: 
          localehz.abmX = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(32378);
          return 0;
        }
        localehz.abmZ = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(32378);
        return 0;
      }
      AppMethodBeat.o(32378);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ehz
 * JD-Core Version:    0.7.0.1
 */