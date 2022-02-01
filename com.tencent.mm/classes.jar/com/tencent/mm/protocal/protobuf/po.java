package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class po
  extends erp
{
  public int IJG;
  public String ProductID;
  public LinkedList<String> YTa;
  public String YTb;
  public double YTc;
  public double YTd;
  
  public po()
  {
    AppMethodBeat.i(124427);
    this.YTa = new LinkedList();
    AppMethodBeat.o(124427);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124428);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ProductID != null) {
        paramVarArgs.g(2, this.ProductID);
      }
      paramVarArgs.e(3, 1, this.YTa);
      paramVarArgs.bS(4, this.IJG);
      if (this.YTb != null) {
        paramVarArgs.g(5, this.YTb);
      }
      paramVarArgs.d(6, this.YTc);
      paramVarArgs.d(7, this.YTd);
      AppMethodBeat.o(124428);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label606;
      }
    }
    label606:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ProductID != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.ProductID);
      }
      i = i + i.a.a.a.c(3, 1, this.YTa) + i.a.a.b.b.a.cJ(4, this.IJG);
      paramInt = i;
      if (this.YTb != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.YTb);
      }
      i = i.a.a.b.b.a.ko(6);
      int j = i.a.a.b.b.a.ko(7);
      AppMethodBeat.o(124428);
      return paramInt + (i + 8) + (j + 8);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YTa.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(124428);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        po localpo = (po)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124428);
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
            localpo.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(124428);
          return 0;
        case 2: 
          localpo.ProductID = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(124428);
          return 0;
        case 3: 
          localpo.YTa.add(((i.a.a.a.a)localObject).ajGk.readString());
          AppMethodBeat.o(124428);
          return 0;
        case 4: 
          localpo.IJG = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(124428);
          return 0;
        case 5: 
          localpo.YTb = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(124428);
          return 0;
        case 6: 
          localpo.YTc = Double.longBitsToDouble(((i.a.a.a.a)localObject).ajGk.aay());
          AppMethodBeat.o(124428);
          return 0;
        }
        localpo.YTd = Double.longBitsToDouble(((i.a.a.a.a)localObject).ajGk.aay());
        AppMethodBeat.o(124428);
        return 0;
      }
      AppMethodBeat.o(124428);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.po
 * JD-Core Version:    0.7.0.1
 */