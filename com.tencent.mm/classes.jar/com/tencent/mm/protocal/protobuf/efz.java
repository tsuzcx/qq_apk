package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class efz
  extends cvc
{
  public int GKV;
  public String HBy;
  public LinkedList<String> HQY;
  public boolean HQZ;
  public String HRa;
  public boolean HRb;
  public boolean HRc;
  public String duW;
  
  public efz()
  {
    AppMethodBeat.i(153313);
    this.HQY = new LinkedList();
    AppMethodBeat.o(153313);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153314);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.duW != null) {
        paramVarArgs.d(2, this.duW);
      }
      paramVarArgs.e(3, 1, this.HQY);
      paramVarArgs.bt(4, this.HQZ);
      if (this.HRa != null) {
        paramVarArgs.d(5, this.HRa);
      }
      paramVarArgs.bt(6, this.HRb);
      if (this.HBy != null) {
        paramVarArgs.d(7, this.HBy);
      }
      paramVarArgs.bt(8, this.HRc);
      paramVarArgs.aS(9, this.GKV);
      AppMethodBeat.o(153314);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label722;
      }
    }
    label722:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.duW != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.duW);
      }
      i = i + f.a.a.a.c(3, 1, this.HQY) + f.a.a.b.b.a.alV(4);
      paramInt = i;
      if (this.HRa != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.HRa);
      }
      i = paramInt + f.a.a.b.b.a.alV(6);
      paramInt = i;
      if (this.HBy != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.HBy);
      }
      i = f.a.a.b.b.a.alV(8);
      int j = f.a.a.b.b.a.bz(9, this.GKV);
      AppMethodBeat.o(153314);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HQY.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(153314);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        efz localefz = (efz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153314);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localefz.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153314);
          return 0;
        case 2: 
          localefz.duW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(153314);
          return 0;
        case 3: 
          localefz.HQY.add(((f.a.a.a.a)localObject1).NPN.readString());
          AppMethodBeat.o(153314);
          return 0;
        case 4: 
          localefz.HQZ = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(153314);
          return 0;
        case 5: 
          localefz.HRa = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(153314);
          return 0;
        case 6: 
          localefz.HRb = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(153314);
          return 0;
        case 7: 
          localefz.HBy = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(153314);
          return 0;
        case 8: 
          localefz.HRc = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(153314);
          return 0;
        }
        localefz.GKV = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(153314);
        return 0;
      }
      AppMethodBeat.o(153314);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.efz
 * JD-Core Version:    0.7.0.1
 */