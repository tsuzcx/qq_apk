package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aph
  extends cvw
{
  public alw GDR;
  public int GGv;
  public String GGw;
  public int GGx;
  public long commentId;
  public String objectNonceId;
  public int opType;
  public long rPT;
  public long rRn;
  public int scene;
  public String sessionBuffer;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169002);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aZ(2, this.rRn);
      paramVarArgs.aZ(3, this.commentId);
      paramVarArgs.aS(4, this.opType);
      paramVarArgs.aZ(5, this.rPT);
      paramVarArgs.aS(6, this.GGv);
      if (this.username != null) {
        paramVarArgs.d(7, this.username);
      }
      paramVarArgs.aS(8, this.scene);
      if (this.objectNonceId != null) {
        paramVarArgs.d(9, this.objectNonceId);
      }
      if (this.GDR != null)
      {
        paramVarArgs.lJ(10, this.GDR.computeSize());
        this.GDR.writeFields(paramVarArgs);
      }
      if (this.sessionBuffer != null) {
        paramVarArgs.d(11, this.sessionBuffer);
      }
      if (this.GGw != null) {
        paramVarArgs.d(12, this.GGw);
      }
      paramVarArgs.aS(13, this.GGx);
      AppMethodBeat.o(169002);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1022;
      }
    }
    label1022:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.rRn) + f.a.a.b.b.a.p(3, this.commentId) + f.a.a.b.b.a.bz(4, this.opType) + f.a.a.b.b.a.p(5, this.rPT) + f.a.a.b.b.a.bz(6, this.GGv);
      paramInt = i;
      if (this.username != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.username);
      }
      i = paramInt + f.a.a.b.b.a.bz(8, this.scene);
      paramInt = i;
      if (this.objectNonceId != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.objectNonceId);
      }
      i = paramInt;
      if (this.GDR != null) {
        i = paramInt + f.a.a.a.lI(10, this.GDR.computeSize());
      }
      paramInt = i;
      if (this.sessionBuffer != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.sessionBuffer);
      }
      i = paramInt;
      if (this.GGw != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.GGw);
      }
      paramInt = f.a.a.b.b.a.bz(13, this.GGx);
      AppMethodBeat.o(169002);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(169002);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aph localaph = (aph)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169002);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaph.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169002);
          return 0;
        case 2: 
          localaph.rRn = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(169002);
          return 0;
        case 3: 
          localaph.commentId = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(169002);
          return 0;
        case 4: 
          localaph.opType = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(169002);
          return 0;
        case 5: 
          localaph.rPT = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(169002);
          return 0;
        case 6: 
          localaph.GGv = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(169002);
          return 0;
        case 7: 
          localaph.username = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(169002);
          return 0;
        case 8: 
          localaph.scene = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(169002);
          return 0;
        case 9: 
          localaph.objectNonceId = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(169002);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new alw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((alw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaph.GDR = ((alw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169002);
          return 0;
        case 11: 
          localaph.sessionBuffer = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(169002);
          return 0;
        case 12: 
          localaph.GGw = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(169002);
          return 0;
        }
        localaph.GGx = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(169002);
        return 0;
      }
      AppMethodBeat.o(169002);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aph
 * JD-Core Version:    0.7.0.1
 */