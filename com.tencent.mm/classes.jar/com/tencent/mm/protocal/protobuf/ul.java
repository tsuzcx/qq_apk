package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ul
  extends cvw
{
  public String FOf;
  public String FOg;
  public String Gmg;
  public String Gmh;
  public int channel;
  public int vxx;
  public int yns;
  public String yoM;
  public String yoN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91403);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FOf != null) {
        paramVarArgs.d(2, this.FOf);
      }
      if (this.FOg != null) {
        paramVarArgs.d(3, this.FOg);
      }
      paramVarArgs.aS(4, this.vxx);
      if (this.yoN != null) {
        paramVarArgs.d(5, this.yoN);
      }
      if (this.yoM != null) {
        paramVarArgs.d(6, this.yoM);
      }
      paramVarArgs.aS(7, this.channel);
      paramVarArgs.aS(8, this.yns);
      if (this.Gmg != null) {
        paramVarArgs.d(9, this.Gmg);
      }
      if (this.Gmh != null) {
        paramVarArgs.d(10, this.Gmh);
      }
      AppMethodBeat.o(91403);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label810;
      }
    }
    label810:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FOf != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FOf);
      }
      i = paramInt;
      if (this.FOg != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FOg);
      }
      i += f.a.a.b.b.a.bz(4, this.vxx);
      paramInt = i;
      if (this.yoN != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.yoN);
      }
      i = paramInt;
      if (this.yoM != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.yoM);
      }
      i = i + f.a.a.b.b.a.bz(7, this.channel) + f.a.a.b.b.a.bz(8, this.yns);
      paramInt = i;
      if (this.Gmg != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.Gmg);
      }
      i = paramInt;
      if (this.Gmh != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.Gmh);
      }
      AppMethodBeat.o(91403);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91403);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ul localul = (ul)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91403);
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
            localul.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91403);
          return 0;
        case 2: 
          localul.FOf = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91403);
          return 0;
        case 3: 
          localul.FOg = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91403);
          return 0;
        case 4: 
          localul.vxx = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91403);
          return 0;
        case 5: 
          localul.yoN = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91403);
          return 0;
        case 6: 
          localul.yoM = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91403);
          return 0;
        case 7: 
          localul.channel = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91403);
          return 0;
        case 8: 
          localul.yns = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91403);
          return 0;
        case 9: 
          localul.Gmg = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91403);
          return 0;
        }
        localul.Gmh = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91403);
        return 0;
      }
      AppMethodBeat.o(91403);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ul
 * JD-Core Version:    0.7.0.1
 */