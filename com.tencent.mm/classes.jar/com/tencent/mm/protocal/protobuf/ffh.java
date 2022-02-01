package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ffh
  extends erp
{
  public int IJG;
  public String IKH;
  public int YIq;
  public long abES;
  public int vgN;
  public LinkedList<etl> vgO;
  
  public ffh()
  {
    AppMethodBeat.i(125821);
    this.vgO = new LinkedList();
    AppMethodBeat.o(125821);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125822);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.YIq);
      paramVarArgs.bv(3, this.abES);
      if (this.IKH != null) {
        paramVarArgs.g(4, this.IKH);
      }
      paramVarArgs.bS(5, this.vgN);
      paramVarArgs.e(6, 8, this.vgO);
      paramVarArgs.bS(7, this.IJG);
      AppMethodBeat.o(125822);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label646;
      }
    }
    label646:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.YIq) + i.a.a.b.b.a.q(3, this.abES);
      paramInt = i;
      if (this.IKH != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.IKH);
      }
      i = i.a.a.b.b.a.cJ(5, this.vgN);
      int j = i.a.a.a.c(6, 8, this.vgO);
      int k = i.a.a.b.b.a.cJ(7, this.IJG);
      AppMethodBeat.o(125822);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.vgO.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(125822);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ffh localffh = (ffh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125822);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localffh.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125822);
          return 0;
        case 2: 
          localffh.YIq = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125822);
          return 0;
        case 3: 
          localffh.abES = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(125822);
          return 0;
        case 4: 
          localffh.IKH = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(125822);
          return 0;
        case 5: 
          localffh.vgN = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125822);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new etl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((etl)localObject2).dh((byte[])localObject1);
            }
            localffh.vgO.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125822);
          return 0;
        }
        localffh.IJG = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(125822);
        return 0;
      }
      AppMethodBeat.o(125822);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ffh
 * JD-Core Version:    0.7.0.1
 */