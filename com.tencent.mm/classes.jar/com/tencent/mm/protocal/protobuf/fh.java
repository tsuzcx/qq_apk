package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fh
  extends cvw
{
  public int FPb;
  public int FPc;
  public int FPd;
  public int FQb;
  public String FQc;
  public int FQd;
  public int FQe;
  public int oGc;
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
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      paramVarArgs.aS(5, this.FQb);
      if (this.FQc != null) {
        paramVarArgs.d(6, this.FQc);
      }
      paramVarArgs.aS(7, this.FQd);
      paramVarArgs.aS(8, this.oGc);
      paramVarArgs.aS(9, this.FQe);
      paramVarArgs.aS(10, this.scene);
      paramVarArgs.aS(11, this.FPd);
      paramVarArgs.aS(12, this.FPc);
      paramVarArgs.aS(13, this.FPb);
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
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.url != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.url);
      }
      i += f.a.a.b.b.a.bz(5, this.FQb);
      paramInt = i;
      if (this.FQc != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FQc);
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.FQd) + f.a.a.b.b.a.bz(8, this.oGc) + f.a.a.b.b.a.bz(9, this.FQe) + f.a.a.b.b.a.bz(10, this.scene) + f.a.a.b.b.a.bz(11, this.FPd) + f.a.a.b.b.a.bz(12, this.FPc) + f.a.a.b.b.a.bz(13, this.FPb);
      paramInt = i;
      if (this.session_id != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.session_id);
      }
      AppMethodBeat.o(177339);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(177339);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        fh localfh = (fh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 3: 
        case 4: 
        default: 
          AppMethodBeat.o(177339);
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
            localfh.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(177339);
          return 0;
        case 2: 
          localfh.url = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(177339);
          return 0;
        case 5: 
          localfh.FQb = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(177339);
          return 0;
        case 6: 
          localfh.FQc = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(177339);
          return 0;
        case 7: 
          localfh.FQd = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(177339);
          return 0;
        case 8: 
          localfh.oGc = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(177339);
          return 0;
        case 9: 
          localfh.FQe = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(177339);
          return 0;
        case 10: 
          localfh.scene = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(177339);
          return 0;
        case 11: 
          localfh.FPd = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(177339);
          return 0;
        case 12: 
          localfh.FPc = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(177339);
          return 0;
        case 13: 
          localfh.FPb = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(177339);
          return 0;
        }
        localfh.session_id = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(177339);
        return 0;
      }
      AppMethodBeat.o(177339);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fh
 * JD-Core Version:    0.7.0.1
 */