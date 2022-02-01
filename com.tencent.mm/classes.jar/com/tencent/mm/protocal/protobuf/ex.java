package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ex
  extends ckq
{
  public int CyP;
  public int CyQ;
  public int CyR;
  public int scene;
  public String session_id;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103193);
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
      paramVarArgs.aR(3, this.scene);
      paramVarArgs.aR(4, this.CyR);
      paramVarArgs.aR(5, this.CyQ);
      paramVarArgs.aR(6, this.CyP);
      if (this.session_id != null) {
        paramVarArgs.d(7, this.session_id);
      }
      AppMethodBeat.o(103193);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label606;
      }
    }
    label606:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.url != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.url);
      }
      i = i + f.a.a.b.b.a.bA(3, this.scene) + f.a.a.b.b.a.bA(4, this.CyR) + f.a.a.b.b.a.bA(5, this.CyQ) + f.a.a.b.b.a.bA(6, this.CyP);
      paramInt = i;
      if (this.session_id != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.session_id);
      }
      AppMethodBeat.o(103193);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(103193);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ex localex = (ex)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(103193);
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
            localex.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103193);
          return 0;
        case 2: 
          localex.url = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(103193);
          return 0;
        case 3: 
          localex.scene = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(103193);
          return 0;
        case 4: 
          localex.CyR = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(103193);
          return 0;
        case 5: 
          localex.CyQ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(103193);
          return 0;
        case 6: 
          localex.CyP = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(103193);
          return 0;
        }
        localex.session_id = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(103193);
        return 0;
      }
      AppMethodBeat.o(103193);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ex
 * JD-Core Version:    0.7.0.1
 */