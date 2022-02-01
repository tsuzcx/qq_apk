package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dgr
  extends ckq
{
  public int CLK;
  public int Exe;
  public int Exf;
  public int Exg;
  public int bvJ;
  public int scene;
  public String session_id;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123664);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.scene);
      paramVarArgs.aR(3, this.Exe);
      paramVarArgs.aR(4, this.CLK);
      paramVarArgs.aR(5, this.Exf);
      paramVarArgs.aR(6, this.Exg);
      if (this.username != null) {
        paramVarArgs.d(7, this.username);
      }
      paramVarArgs.aR(8, this.bvJ);
      if (this.session_id != null) {
        paramVarArgs.d(9, this.session_id);
      }
      AppMethodBeat.o(123664);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label694;
      }
    }
    label694:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.scene) + f.a.a.b.b.a.bA(3, this.Exe) + f.a.a.b.b.a.bA(4, this.CLK) + f.a.a.b.b.a.bA(5, this.Exf) + f.a.a.b.b.a.bA(6, this.Exg);
      paramInt = i;
      if (this.username != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.username);
      }
      i = paramInt + f.a.a.b.b.a.bA(8, this.bvJ);
      paramInt = i;
      if (this.session_id != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.session_id);
      }
      AppMethodBeat.o(123664);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(123664);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dgr localdgr = (dgr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123664);
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
            localdgr.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123664);
          return 0;
        case 2: 
          localdgr.scene = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(123664);
          return 0;
        case 3: 
          localdgr.Exe = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(123664);
          return 0;
        case 4: 
          localdgr.CLK = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(123664);
          return 0;
        case 5: 
          localdgr.Exf = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(123664);
          return 0;
        case 6: 
          localdgr.Exg = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(123664);
          return 0;
        case 7: 
          localdgr.username = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123664);
          return 0;
        case 8: 
          localdgr.bvJ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(123664);
          return 0;
        }
        localdgr.session_id = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(123664);
        return 0;
      }
      AppMethodBeat.o(123664);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dgr
 * JD-Core Version:    0.7.0.1
 */