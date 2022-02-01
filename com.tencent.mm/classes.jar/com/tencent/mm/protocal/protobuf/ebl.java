package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class ebl
  extends ckq
{
  public int CJZ;
  public String EEF;
  public long LwA;
  public String LwB;
  public b LyM;
  public String content;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(202529);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.LyM != null) {
        paramVarArgs.c(2, this.LyM);
      }
      paramVarArgs.aR(3, this.CJZ);
      if (this.content != null) {
        paramVarArgs.d(4, this.content);
      }
      paramVarArgs.aG(5, this.LwA);
      if (this.EEF != null) {
        paramVarArgs.d(6, this.EEF);
      }
      if (this.LwB != null) {
        paramVarArgs.d(7, this.LwB);
      }
      AppMethodBeat.o(202529);
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
      if (this.LyM != null) {
        i = paramInt + f.a.a.b.b.a.b(2, this.LyM);
      }
      i += f.a.a.b.b.a.bA(3, this.CJZ);
      paramInt = i;
      if (this.content != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.content);
      }
      i = paramInt + f.a.a.b.b.a.q(5, this.LwA);
      paramInt = i;
      if (this.EEF != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.EEF);
      }
      i = paramInt;
      if (this.LwB != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.LwB);
      }
      AppMethodBeat.o(202529);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(202529);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ebl localebl = (ebl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(202529);
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
            localebl.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(202529);
          return 0;
        case 2: 
          localebl.LyM = ((f.a.a.a.a)localObject1).KhF.fMu();
          AppMethodBeat.o(202529);
          return 0;
        case 3: 
          localebl.CJZ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(202529);
          return 0;
        case 4: 
          localebl.content = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(202529);
          return 0;
        case 5: 
          localebl.LwA = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(202529);
          return 0;
        case 6: 
          localebl.EEF = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(202529);
          return 0;
        }
        localebl.LwB = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(202529);
        return 0;
      }
      AppMethodBeat.o(202529);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ebl
 * JD-Core Version:    0.7.0.1
 */