package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class czg
  extends cqk
{
  public int FIA;
  public b FIB;
  public String FIm;
  public String FIn;
  public String FIo;
  public int FIy;
  public int FIz;
  public String FhW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117928);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.FIm != null) {
        paramVarArgs.d(2, this.FIm);
      }
      paramVarArgs.aR(3, this.FIy);
      paramVarArgs.aR(4, this.FIz);
      if (this.FIn != null) {
        paramVarArgs.d(5, this.FIn);
      }
      if (this.FIo != null) {
        paramVarArgs.d(6, this.FIo);
      }
      paramVarArgs.aR(7, this.FIA);
      if (this.FhW != null) {
        paramVarArgs.d(8, this.FhW);
      }
      if (this.FIB != null) {
        paramVarArgs.c(9, this.FIB);
      }
      AppMethodBeat.o(117928);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label750;
      }
    }
    label750:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FIm != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.FIm);
      }
      i = i + f.a.a.b.b.a.bx(3, this.FIy) + f.a.a.b.b.a.bx(4, this.FIz);
      paramInt = i;
      if (this.FIn != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FIn);
      }
      i = paramInt;
      if (this.FIo != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.FIo);
      }
      i += f.a.a.b.b.a.bx(7, this.FIA);
      paramInt = i;
      if (this.FhW != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.FhW);
      }
      i = paramInt;
      if (this.FIB != null) {
        i = paramInt + f.a.a.b.b.a.b(9, this.FIB);
      }
      AppMethodBeat.o(117928);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(117928);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        czg localczg = (czg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117928);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localczg.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117928);
          return 0;
        case 2: 
          localczg.FIm = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(117928);
          return 0;
        case 3: 
          localczg.FIy = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(117928);
          return 0;
        case 4: 
          localczg.FIz = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(117928);
          return 0;
        case 5: 
          localczg.FIn = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(117928);
          return 0;
        case 6: 
          localczg.FIo = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(117928);
          return 0;
        case 7: 
          localczg.FIA = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(117928);
          return 0;
        case 8: 
          localczg.FhW = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(117928);
          return 0;
        }
        localczg.FIB = ((f.a.a.a.a)localObject1).LVo.gfk();
        AppMethodBeat.o(117928);
        return 0;
      }
      AppMethodBeat.o(117928);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czg
 * JD-Core Version:    0.7.0.1
 */