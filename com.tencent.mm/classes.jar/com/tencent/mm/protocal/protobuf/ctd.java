package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ctd
  extends erp
{
  public int IHg;
  public String IJD;
  public LinkedList<etl> IJY;
  public int IKo;
  public int IKp;
  public int aayZ;
  
  public ctd()
  {
    AppMethodBeat.i(152596);
    this.IJY = new LinkedList();
    AppMethodBeat.o(152596);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152597);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.IHg);
      paramVarArgs.bS(3, this.IKo);
      paramVarArgs.bS(4, this.IKp);
      if (this.IJD != null) {
        paramVarArgs.g(5, this.IJD);
      }
      paramVarArgs.bS(6, this.aayZ);
      paramVarArgs.e(7, 8, this.IJY);
      AppMethodBeat.o(152597);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label642;
      }
    }
    label642:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.IHg) + i.a.a.b.b.a.cJ(3, this.IKo) + i.a.a.b.b.a.cJ(4, this.IKp);
      paramInt = i;
      if (this.IJD != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.IJD);
      }
      i = i.a.a.b.b.a.cJ(6, this.aayZ);
      int j = i.a.a.a.c(7, 8, this.IJY);
      AppMethodBeat.o(152597);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.IJY.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(152597);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ctd localctd = (ctd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152597);
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
            localctd.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152597);
          return 0;
        case 2: 
          localctd.IHg = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152597);
          return 0;
        case 3: 
          localctd.IKo = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152597);
          return 0;
        case 4: 
          localctd.IKp = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152597);
          return 0;
        case 5: 
          localctd.IJD = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152597);
          return 0;
        case 6: 
          localctd.aayZ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152597);
          return 0;
        }
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
          localctd.IJY.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(152597);
        return 0;
      }
      AppMethodBeat.o(152597);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctd
 * JD-Core Version:    0.7.0.1
 */