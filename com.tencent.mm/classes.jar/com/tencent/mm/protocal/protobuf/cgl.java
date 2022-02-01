package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cgl
  extends cqk
{
  public String DMv;
  public String DMw;
  public String FnQ;
  public String Fut;
  public String Fuu;
  public String Fuv;
  public String Fuw;
  public String content;
  public boolean nWS;
  public String nWi;
  public int status;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114055);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.DMv != null) {
        paramVarArgs.d(2, this.DMv);
      }
      if (this.DMw != null) {
        paramVarArgs.d(3, this.DMw);
      }
      paramVarArgs.aR(4, this.status);
      if (this.content != null) {
        paramVarArgs.d(5, this.content);
      }
      if (this.nWi != null) {
        paramVarArgs.d(6, this.nWi);
      }
      if (this.FnQ != null) {
        paramVarArgs.d(7, this.FnQ);
      }
      paramVarArgs.bl(8, this.nWS);
      if (this.Fut != null) {
        paramVarArgs.d(9, this.Fut);
      }
      if (this.Fuu != null) {
        paramVarArgs.d(10, this.Fuu);
      }
      if (this.Fuv != null) {
        paramVarArgs.d(11, this.Fuv);
      }
      if (this.Fuw != null) {
        paramVarArgs.d(12, this.Fuw);
      }
      AppMethodBeat.o(114055);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label950;
      }
    }
    label950:
    for (int i = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DMv != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DMv);
      }
      i = paramInt;
      if (this.DMw != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DMw);
      }
      i += f.a.a.b.b.a.bx(4, this.status);
      paramInt = i;
      if (this.content != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.content);
      }
      i = paramInt;
      if (this.nWi != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.nWi);
      }
      paramInt = i;
      if (this.FnQ != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FnQ);
      }
      i = paramInt + (f.a.a.b.b.a.fK(8) + 1);
      paramInt = i;
      if (this.Fut != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.Fut);
      }
      i = paramInt;
      if (this.Fuu != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.Fuu);
      }
      paramInt = i;
      if (this.Fuv != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.Fuv);
      }
      i = paramInt;
      if (this.Fuw != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.Fuw);
      }
      AppMethodBeat.o(114055);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(114055);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cgl localcgl = (cgl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114055);
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
            localcgl.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114055);
          return 0;
        case 2: 
          localcgl.DMv = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114055);
          return 0;
        case 3: 
          localcgl.DMw = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114055);
          return 0;
        case 4: 
          localcgl.status = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(114055);
          return 0;
        case 5: 
          localcgl.content = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114055);
          return 0;
        case 6: 
          localcgl.nWi = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114055);
          return 0;
        case 7: 
          localcgl.FnQ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114055);
          return 0;
        case 8: 
          localcgl.nWS = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(114055);
          return 0;
        case 9: 
          localcgl.Fut = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114055);
          return 0;
        case 10: 
          localcgl.Fuu = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114055);
          return 0;
        case 11: 
          localcgl.Fuv = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114055);
          return 0;
        }
        localcgl.Fuw = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(114055);
        return 0;
      }
      AppMethodBeat.o(114055);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgl
 * JD-Core Version:    0.7.0.1
 */