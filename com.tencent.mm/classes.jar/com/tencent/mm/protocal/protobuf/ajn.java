package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ajn
  extends ckq
{
  public aht Dkw;
  public int DlA;
  public String LxG;
  public long commentId;
  public long objectId;
  public String objectNonceId;
  public int opType;
  public long qou;
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
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aG(2, this.objectId);
      paramVarArgs.aG(3, this.commentId);
      paramVarArgs.aR(4, this.opType);
      paramVarArgs.aG(5, this.qou);
      paramVarArgs.aR(6, this.DlA);
      if (this.username != null) {
        paramVarArgs.d(7, this.username);
      }
      paramVarArgs.aR(8, this.scene);
      if (this.objectNonceId != null) {
        paramVarArgs.d(9, this.objectNonceId);
      }
      if (this.Dkw != null)
      {
        paramVarArgs.kX(10, this.Dkw.computeSize());
        this.Dkw.writeFields(paramVarArgs);
      }
      if (this.sessionBuffer != null) {
        paramVarArgs.d(11, this.sessionBuffer);
      }
      if (this.LxG != null) {
        paramVarArgs.d(12, this.LxG);
      }
      AppMethodBeat.o(169002);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label974;
      }
    }
    label974:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.q(2, this.objectId) + f.a.a.b.b.a.q(3, this.commentId) + f.a.a.b.b.a.bA(4, this.opType) + f.a.a.b.b.a.q(5, this.qou) + f.a.a.b.b.a.bA(6, this.DlA);
      paramInt = i;
      if (this.username != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.username);
      }
      i = paramInt + f.a.a.b.b.a.bA(8, this.scene);
      paramInt = i;
      if (this.objectNonceId != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.objectNonceId);
      }
      i = paramInt;
      if (this.Dkw != null) {
        i = paramInt + f.a.a.a.kW(10, this.Dkw.computeSize());
      }
      paramInt = i;
      if (this.sessionBuffer != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.sessionBuffer);
      }
      i = paramInt;
      if (this.LxG != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.LxG);
      }
      AppMethodBeat.o(169002);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(169002);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ajn localajn = (ajn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169002);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localajn.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169002);
          return 0;
        case 2: 
          localajn.objectId = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(169002);
          return 0;
        case 3: 
          localajn.commentId = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(169002);
          return 0;
        case 4: 
          localajn.opType = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(169002);
          return 0;
        case 5: 
          localajn.qou = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(169002);
          return 0;
        case 6: 
          localajn.DlA = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(169002);
          return 0;
        case 7: 
          localajn.username = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(169002);
          return 0;
        case 8: 
          localajn.scene = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(169002);
          return 0;
        case 9: 
          localajn.objectNonceId = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(169002);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aht();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aht)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localajn.Dkw = ((aht)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169002);
          return 0;
        case 11: 
          localajn.sessionBuffer = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(169002);
          return 0;
        }
        localajn.LxG = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(169002);
        return 0;
      }
      AppMethodBeat.o(169002);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajn
 * JD-Core Version:    0.7.0.1
 */