package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ajq
  extends cvw
{
  public float GgZ;
  public float Gha;
  public String Gze;
  public int Gzf;
  public String Gzg;
  public String Gzh;
  public int Gzi;
  public int OpCode;
  public String xrf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32207);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.OpCode);
      if (this.Gze != null) {
        paramVarArgs.d(3, this.Gze);
      }
      paramVarArgs.y(4, this.GgZ);
      paramVarArgs.y(5, this.Gha);
      paramVarArgs.aS(6, this.Gzf);
      if (this.Gzg != null) {
        paramVarArgs.d(7, this.Gzg);
      }
      if (this.Gzh != null) {
        paramVarArgs.d(8, this.Gzh);
      }
      paramVarArgs.aS(9, this.Gzi);
      if (this.xrf != null) {
        paramVarArgs.d(10, this.xrf);
      }
      AppMethodBeat.o(32207);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label792;
      }
    }
    label792:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.OpCode);
      paramInt = i;
      if (this.Gze != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Gze);
      }
      i = paramInt + f.a.a.b.b.a.amE(4) + f.a.a.b.b.a.amE(5) + f.a.a.b.b.a.bz(6, this.Gzf);
      paramInt = i;
      if (this.Gzg != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Gzg);
      }
      i = paramInt;
      if (this.Gzh != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.Gzh);
      }
      i += f.a.a.b.b.a.bz(9, this.Gzi);
      paramInt = i;
      if (this.xrf != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.xrf);
      }
      AppMethodBeat.o(32207);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(32207);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ajq localajq = (ajq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32207);
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
            localajq.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32207);
          return 0;
        case 2: 
          localajq.OpCode = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32207);
          return 0;
        case 3: 
          localajq.Gze = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32207);
          return 0;
        case 4: 
          localajq.GgZ = Float.intBitsToFloat(((f.a.a.a.a)localObject1).OmT.gwb());
          AppMethodBeat.o(32207);
          return 0;
        case 5: 
          localajq.Gha = Float.intBitsToFloat(((f.a.a.a.a)localObject1).OmT.gwb());
          AppMethodBeat.o(32207);
          return 0;
        case 6: 
          localajq.Gzf = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32207);
          return 0;
        case 7: 
          localajq.Gzg = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32207);
          return 0;
        case 8: 
          localajq.Gzh = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32207);
          return 0;
        case 9: 
          localajq.Gzi = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32207);
          return 0;
        }
        localajq.xrf = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(32207);
        return 0;
      }
      AppMethodBeat.o(32207);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajq
 * JD-Core Version:    0.7.0.1
 */