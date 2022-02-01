package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fj
  extends cvw
{
  public int FPb;
  public int FPc;
  public int FPd;
  public String FQf;
  public String iaa;
  public int oGc;
  public int scene;
  public String session_id;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103197);
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
      if (this.iaa != null) {
        paramVarArgs.d(3, this.iaa);
      }
      if (this.FQf != null) {
        paramVarArgs.d(4, this.FQf);
      }
      paramVarArgs.aS(5, this.scene);
      paramVarArgs.aS(6, this.FPd);
      paramVarArgs.aS(7, this.FPc);
      paramVarArgs.aS(8, this.oGc);
      paramVarArgs.aS(10, this.FPb);
      if (this.session_id != null) {
        paramVarArgs.d(11, this.session_id);
      }
      AppMethodBeat.o(103197);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label778;
      }
    }
    label778:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.url);
      }
      i = paramInt;
      if (this.iaa != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.iaa);
      }
      paramInt = i;
      if (this.FQf != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FQf);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.scene) + f.a.a.b.b.a.bz(6, this.FPd) + f.a.a.b.b.a.bz(7, this.FPc) + f.a.a.b.b.a.bz(8, this.oGc) + f.a.a.b.b.a.bz(10, this.FPb);
      paramInt = i;
      if (this.session_id != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.session_id);
      }
      AppMethodBeat.o(103197);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(103197);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        fj localfj = (fj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 9: 
        default: 
          AppMethodBeat.o(103197);
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
            localfj.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103197);
          return 0;
        case 2: 
          localfj.url = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(103197);
          return 0;
        case 3: 
          localfj.iaa = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(103197);
          return 0;
        case 4: 
          localfj.FQf = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(103197);
          return 0;
        case 5: 
          localfj.scene = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(103197);
          return 0;
        case 6: 
          localfj.FPd = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(103197);
          return 0;
        case 7: 
          localfj.FPc = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(103197);
          return 0;
        case 8: 
          localfj.oGc = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(103197);
          return 0;
        case 10: 
          localfj.FPb = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(103197);
          return 0;
        }
        localfj.session_id = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(103197);
        return 0;
      }
      AppMethodBeat.o(103197);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fj
 * JD-Core Version:    0.7.0.1
 */