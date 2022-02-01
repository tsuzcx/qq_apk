package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class yz
  extends ckq
{
  public String CWC;
  public String CWy;
  public String Dbd;
  public long Dbe;
  public int lpz;
  public String sYt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72466);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Dbd != null) {
        paramVarArgs.d(2, this.Dbd);
      }
      paramVarArgs.aG(3, this.Dbe);
      if (this.CWy != null) {
        paramVarArgs.d(4, this.CWy);
      }
      if (this.CWC != null) {
        paramVarArgs.d(5, this.CWC);
      }
      paramVarArgs.aR(6, this.lpz);
      if (this.sYt != null) {
        paramVarArgs.d(7, this.sYt);
      }
      AppMethodBeat.o(72466);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label642;
      }
    }
    label642:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Dbd != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Dbd);
      }
      i += f.a.a.b.b.a.q(3, this.Dbe);
      paramInt = i;
      if (this.CWy != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.CWy);
      }
      i = paramInt;
      if (this.CWC != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.CWC);
      }
      i += f.a.a.b.b.a.bA(6, this.lpz);
      paramInt = i;
      if (this.sYt != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.sYt);
      }
      AppMethodBeat.o(72466);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(72466);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        yz localyz = (yz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72466);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localyz.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72466);
          return 0;
        case 2: 
          localyz.Dbd = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72466);
          return 0;
        case 3: 
          localyz.Dbe = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(72466);
          return 0;
        case 4: 
          localyz.CWy = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72466);
          return 0;
        case 5: 
          localyz.CWC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72466);
          return 0;
        case 6: 
          localyz.lpz = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72466);
          return 0;
        }
        localyz.sYt = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(72466);
        return 0;
      }
      AppMethodBeat.o(72466);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yz
 * JD-Core Version:    0.7.0.1
 */