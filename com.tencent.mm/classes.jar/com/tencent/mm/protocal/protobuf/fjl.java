package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fjl
  extends erp
{
  public int IcB;
  public String UserName;
  public String YFk;
  public String abDu;
  public long abDv;
  public long abEV;
  public int abEW;
  public long abKe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118476);
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
      if (this.UserName != null) {
        paramVarArgs.g(3, this.UserName);
      }
      paramVarArgs.bv(4, this.abDv);
      paramVarArgs.bv(5, this.abEV);
      paramVarArgs.bS(6, this.abEW);
      paramVarArgs.bv(7, this.abKe);
      paramVarArgs.bS(8, this.IcB);
      if (this.YFk != null) {
        paramVarArgs.g(9, this.YFk);
      }
      AppMethodBeat.o(118476);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label684;
      }
    }
    label684:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.abDu != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.abDu);
      }
      i = paramInt;
      if (this.UserName != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.UserName);
      }
      i = i + i.a.a.b.b.a.q(4, this.abDv) + i.a.a.b.b.a.q(5, this.abEV) + i.a.a.b.b.a.cJ(6, this.abEW) + i.a.a.b.b.a.q(7, this.abKe) + i.a.a.b.b.a.cJ(8, this.IcB);
      paramInt = i;
      if (this.YFk != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.YFk);
      }
      AppMethodBeat.o(118476);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(118476);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fjl localfjl = (fjl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118476);
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
            localfjl.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(118476);
          return 0;
        case 2: 
          localfjl.abDu = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(118476);
          return 0;
        case 3: 
          localfjl.UserName = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(118476);
          return 0;
        case 4: 
          localfjl.abDv = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(118476);
          return 0;
        case 5: 
          localfjl.abEV = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(118476);
          return 0;
        case 6: 
          localfjl.abEW = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(118476);
          return 0;
        case 7: 
          localfjl.abKe = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(118476);
          return 0;
        case 8: 
          localfjl.IcB = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(118476);
          return 0;
        }
        localfjl.YFk = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(118476);
        return 0;
      }
      AppMethodBeat.o(118476);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fjl
 * JD-Core Version:    0.7.0.1
 */