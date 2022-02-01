package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class oy
  extends cvw
{
  public int count;
  public String gvo;
  public String gvp;
  public String gvq;
  public String gvr;
  public String gvs;
  public int gvt;
  public String gvu;
  public int type;
  public String value;
  public int wON;
  public String yCd;
  public String yCe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124452);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.gvo != null) {
        paramVarArgs.d(2, this.gvo);
      }
      if (this.gvp != null) {
        paramVarArgs.d(3, this.gvp);
      }
      if (this.gvq != null) {
        paramVarArgs.d(4, this.gvq);
      }
      if (this.gvr != null) {
        paramVarArgs.d(5, this.gvr);
      }
      if (this.gvs != null) {
        paramVarArgs.d(6, this.gvs);
      }
      paramVarArgs.aS(7, this.gvt);
      if (this.gvu != null) {
        paramVarArgs.d(8, this.gvu);
      }
      if (this.yCe != null) {
        paramVarArgs.d(9, this.yCe);
      }
      if (this.yCd != null) {
        paramVarArgs.d(10, this.yCd);
      }
      paramVarArgs.aS(11, this.type);
      if (this.value != null) {
        paramVarArgs.d(12, this.value);
      }
      paramVarArgs.aS(13, this.count);
      paramVarArgs.aS(14, this.wON);
      AppMethodBeat.o(124452);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1046;
      }
    }
    label1046:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.gvo != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.gvo);
      }
      i = paramInt;
      if (this.gvp != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.gvp);
      }
      paramInt = i;
      if (this.gvq != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.gvq);
      }
      i = paramInt;
      if (this.gvr != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.gvr);
      }
      paramInt = i;
      if (this.gvs != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.gvs);
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.gvt);
      paramInt = i;
      if (this.gvu != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.gvu);
      }
      i = paramInt;
      if (this.yCe != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.yCe);
      }
      paramInt = i;
      if (this.yCd != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.yCd);
      }
      i = paramInt + f.a.a.b.b.a.bz(11, this.type);
      paramInt = i;
      if (this.value != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.value);
      }
      i = f.a.a.b.b.a.bz(13, this.count);
      int j = f.a.a.b.b.a.bz(14, this.wON);
      AppMethodBeat.o(124452);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(124452);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        oy localoy = (oy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124452);
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
            localoy.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124452);
          return 0;
        case 2: 
          localoy.gvo = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(124452);
          return 0;
        case 3: 
          localoy.gvp = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(124452);
          return 0;
        case 4: 
          localoy.gvq = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(124452);
          return 0;
        case 5: 
          localoy.gvr = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(124452);
          return 0;
        case 6: 
          localoy.gvs = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(124452);
          return 0;
        case 7: 
          localoy.gvt = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(124452);
          return 0;
        case 8: 
          localoy.gvu = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(124452);
          return 0;
        case 9: 
          localoy.yCe = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(124452);
          return 0;
        case 10: 
          localoy.yCd = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(124452);
          return 0;
        case 11: 
          localoy.type = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(124452);
          return 0;
        case 12: 
          localoy.value = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(124452);
          return 0;
        case 13: 
          localoy.count = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(124452);
          return 0;
        }
        localoy.wON = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(124452);
        return 0;
      }
      AppMethodBeat.o(124452);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.oy
 * JD-Core Version:    0.7.0.1
 */