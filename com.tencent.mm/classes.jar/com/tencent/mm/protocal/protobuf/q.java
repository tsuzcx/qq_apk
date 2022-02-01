package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class q
  extends ckq
{
  public long CsA;
  public String CsB;
  public String Csi;
  public String Csj;
  public int scene;
  public String vBv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91328);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Csi != null) {
        paramVarArgs.d(2, this.Csi);
      }
      paramVarArgs.aG(3, this.CsA);
      paramVarArgs.aR(4, this.scene);
      if (this.Csj != null) {
        paramVarArgs.d(5, this.Csj);
      }
      if (this.CsB != null) {
        paramVarArgs.d(6, this.CsB);
      }
      if (this.vBv != null) {
        paramVarArgs.d(7, this.vBv);
      }
      AppMethodBeat.o(91328);
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
      if (this.Csi != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Csi);
      }
      i = i + f.a.a.b.b.a.q(3, this.CsA) + f.a.a.b.b.a.bA(4, this.scene);
      paramInt = i;
      if (this.Csj != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Csj);
      }
      i = paramInt;
      if (this.CsB != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.CsB);
      }
      paramInt = i;
      if (this.vBv != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.vBv);
      }
      AppMethodBeat.o(91328);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91328);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        q localq = (q)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91328);
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
            localq.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91328);
          return 0;
        case 2: 
          localq.Csi = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91328);
          return 0;
        case 3: 
          localq.CsA = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(91328);
          return 0;
        case 4: 
          localq.scene = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91328);
          return 0;
        case 5: 
          localq.Csj = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91328);
          return 0;
        case 6: 
          localq.CsB = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91328);
          return 0;
        }
        localq.vBv = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91328);
        return 0;
      }
      AppMethodBeat.o(91328);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.q
 * JD-Core Version:    0.7.0.1
 */