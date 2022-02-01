package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class es
  extends ckq
{
  public int CyP;
  public int CyQ;
  public int CyR;
  public long CyS;
  public int ntg;
  public int offset;
  public int scene;
  public String session_id;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103189);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      paramVarArgs.aR(4, this.offset);
      paramVarArgs.aR(6, this.ntg);
      paramVarArgs.aR(7, this.scene);
      paramVarArgs.aR(8, this.CyR);
      paramVarArgs.aR(9, this.CyQ);
      paramVarArgs.aR(10, this.CyP);
      if (this.session_id != null) {
        paramVarArgs.d(11, this.session_id);
      }
      paramVarArgs.aG(12, this.CyS);
      AppMethodBeat.o(103189);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label750;
      }
    }
    label750:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.url != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.url);
      }
      i = i + f.a.a.b.b.a.bA(4, this.offset) + f.a.a.b.b.a.bA(6, this.ntg) + f.a.a.b.b.a.bA(7, this.scene) + f.a.a.b.b.a.bA(8, this.CyR) + f.a.a.b.b.a.bA(9, this.CyQ) + f.a.a.b.b.a.bA(10, this.CyP);
      paramInt = i;
      if (this.session_id != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.session_id);
      }
      i = f.a.a.b.b.a.q(12, this.CyS);
      AppMethodBeat.o(103189);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(103189);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        es locales = (es)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 3: 
        case 5: 
        default: 
          AppMethodBeat.o(103189);
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
            locales.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103189);
          return 0;
        case 2: 
          locales.url = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(103189);
          return 0;
        case 4: 
          locales.offset = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(103189);
          return 0;
        case 6: 
          locales.ntg = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(103189);
          return 0;
        case 7: 
          locales.scene = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(103189);
          return 0;
        case 8: 
          locales.CyR = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(103189);
          return 0;
        case 9: 
          locales.CyQ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(103189);
          return 0;
        case 10: 
          locales.CyP = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(103189);
          return 0;
        case 11: 
          locales.session_id = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(103189);
          return 0;
        }
        locales.CyS = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(103189);
        return 0;
      }
      AppMethodBeat.o(103189);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.es
 * JD-Core Version:    0.7.0.1
 */