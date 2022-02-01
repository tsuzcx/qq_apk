package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fa
  extends ckq
{
  public int CyP;
  public int CyQ;
  public int CyR;
  public int CzO;
  public String CzP;
  public int CzQ;
  public int CzR;
  public int ntg;
  public int scene;
  public String session_id;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(177339);
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
      paramVarArgs.aR(5, this.CzO);
      if (this.CzP != null) {
        paramVarArgs.d(6, this.CzP);
      }
      paramVarArgs.aR(7, this.CzQ);
      paramVarArgs.aR(8, this.ntg);
      paramVarArgs.aR(9, this.CzR);
      paramVarArgs.aR(10, this.scene);
      paramVarArgs.aR(11, this.CyR);
      paramVarArgs.aR(12, this.CyQ);
      paramVarArgs.aR(13, this.CyP);
      if (this.session_id != null) {
        paramVarArgs.d(14, this.session_id);
      }
      AppMethodBeat.o(177339);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label858;
      }
    }
    label858:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.url != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.url);
      }
      i += f.a.a.b.b.a.bA(5, this.CzO);
      paramInt = i;
      if (this.CzP != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.CzP);
      }
      i = paramInt + f.a.a.b.b.a.bA(7, this.CzQ) + f.a.a.b.b.a.bA(8, this.ntg) + f.a.a.b.b.a.bA(9, this.CzR) + f.a.a.b.b.a.bA(10, this.scene) + f.a.a.b.b.a.bA(11, this.CyR) + f.a.a.b.b.a.bA(12, this.CyQ) + f.a.a.b.b.a.bA(13, this.CyP);
      paramInt = i;
      if (this.session_id != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.session_id);
      }
      AppMethodBeat.o(177339);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(177339);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        fa localfa = (fa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 3: 
        case 4: 
        default: 
          AppMethodBeat.o(177339);
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
            localfa.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(177339);
          return 0;
        case 2: 
          localfa.url = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(177339);
          return 0;
        case 5: 
          localfa.CzO = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(177339);
          return 0;
        case 6: 
          localfa.CzP = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(177339);
          return 0;
        case 7: 
          localfa.CzQ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(177339);
          return 0;
        case 8: 
          localfa.ntg = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(177339);
          return 0;
        case 9: 
          localfa.CzR = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(177339);
          return 0;
        case 10: 
          localfa.scene = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(177339);
          return 0;
        case 11: 
          localfa.CyR = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(177339);
          return 0;
        case 12: 
          localfa.CyQ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(177339);
          return 0;
        case 13: 
          localfa.CyP = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(177339);
          return 0;
        }
        localfa.session_id = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(177339);
        return 0;
      }
      AppMethodBeat.o(177339);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fa
 * JD-Core Version:    0.7.0.1
 */