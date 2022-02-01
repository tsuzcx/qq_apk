package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dsu
  extends cvw
{
  public int Gdl;
  public int HYH;
  public int HYI;
  public int HYJ;
  public int reason;
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
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.scene);
      paramVarArgs.aS(3, this.HYH);
      paramVarArgs.aS(4, this.Gdl);
      paramVarArgs.aS(5, this.HYI);
      paramVarArgs.aS(6, this.HYJ);
      if (this.username != null) {
        paramVarArgs.d(7, this.username);
      }
      paramVarArgs.aS(8, this.reason);
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
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.scene) + f.a.a.b.b.a.bz(3, this.HYH) + f.a.a.b.b.a.bz(4, this.Gdl) + f.a.a.b.b.a.bz(5, this.HYI) + f.a.a.b.b.a.bz(6, this.HYJ);
      paramInt = i;
      if (this.username != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.username);
      }
      i = paramInt + f.a.a.b.b.a.bz(8, this.reason);
      paramInt = i;
      if (this.session_id != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.session_id);
      }
      AppMethodBeat.o(123664);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(123664);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dsu localdsu = (dsu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123664);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdsu.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123664);
          return 0;
        case 2: 
          localdsu.scene = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(123664);
          return 0;
        case 3: 
          localdsu.HYH = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(123664);
          return 0;
        case 4: 
          localdsu.Gdl = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(123664);
          return 0;
        case 5: 
          localdsu.HYI = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(123664);
          return 0;
        case 6: 
          localdsu.HYJ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(123664);
          return 0;
        case 7: 
          localdsu.username = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123664);
          return 0;
        case 8: 
          localdsu.reason = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(123664);
          return 0;
        }
        localdsu.session_id = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(123664);
        return 0;
      }
      AppMethodBeat.o(123664);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsu
 * JD-Core Version:    0.7.0.1
 */