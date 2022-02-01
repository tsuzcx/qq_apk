package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ey
  extends cvw
{
  public int FPb;
  public int FPc;
  public int FPd;
  public long FPe;
  public int oGc;
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
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      paramVarArgs.aS(4, this.offset);
      paramVarArgs.aS(6, this.oGc);
      paramVarArgs.aS(7, this.scene);
      paramVarArgs.aS(8, this.FPd);
      paramVarArgs.aS(9, this.FPc);
      paramVarArgs.aS(10, this.FPb);
      if (this.session_id != null) {
        paramVarArgs.d(11, this.session_id);
      }
      paramVarArgs.aZ(12, this.FPe);
      AppMethodBeat.o(103189);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label750;
      }
    }
    label750:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.url != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.url);
      }
      i = i + f.a.a.b.b.a.bz(4, this.offset) + f.a.a.b.b.a.bz(6, this.oGc) + f.a.a.b.b.a.bz(7, this.scene) + f.a.a.b.b.a.bz(8, this.FPd) + f.a.a.b.b.a.bz(9, this.FPc) + f.a.a.b.b.a.bz(10, this.FPb);
      paramInt = i;
      if (this.session_id != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.session_id);
      }
      i = f.a.a.b.b.a.p(12, this.FPe);
      AppMethodBeat.o(103189);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(103189);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ey localey = (ey)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 3: 
        case 5: 
        default: 
          AppMethodBeat.o(103189);
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
            localey.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103189);
          return 0;
        case 2: 
          localey.url = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(103189);
          return 0;
        case 4: 
          localey.offset = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(103189);
          return 0;
        case 6: 
          localey.oGc = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(103189);
          return 0;
        case 7: 
          localey.scene = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(103189);
          return 0;
        case 8: 
          localey.FPd = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(103189);
          return 0;
        case 9: 
          localey.FPc = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(103189);
          return 0;
        case 10: 
          localey.FPb = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(103189);
          return 0;
        case 11: 
          localey.session_id = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(103189);
          return 0;
        }
        localey.FPe = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(103189);
        return 0;
      }
      AppMethodBeat.o(103189);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ey
 * JD-Core Version:    0.7.0.1
 */