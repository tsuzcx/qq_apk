package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class sa
  extends ckq
{
  public String CTF;
  public String nickname;
  public String nvC;
  public int tav;
  public String vAM;
  public String vAX;
  public String vAY;
  public String vBp;
  public String vBs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91400);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.tav);
      if (this.nvC != null) {
        paramVarArgs.d(3, this.nvC);
      }
      if (this.vBp != null) {
        paramVarArgs.d(4, this.vBp);
      }
      if (this.CTF != null) {
        paramVarArgs.d(5, this.CTF);
      }
      if (this.vAX != null) {
        paramVarArgs.d(6, this.vAX);
      }
      if (this.vAY != null) {
        paramVarArgs.d(7, this.vAY);
      }
      if (this.vBs != null) {
        paramVarArgs.d(8, this.vBs);
      }
      if (this.nickname != null) {
        paramVarArgs.d(9, this.nickname);
      }
      if (this.vAM != null) {
        paramVarArgs.d(10, this.vAM);
      }
      AppMethodBeat.o(91400);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label846;
      }
    }
    label846:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.tav);
      paramInt = i;
      if (this.nvC != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nvC);
      }
      i = paramInt;
      if (this.vBp != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.vBp);
      }
      paramInt = i;
      if (this.CTF != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.CTF);
      }
      i = paramInt;
      if (this.vAX != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.vAX);
      }
      paramInt = i;
      if (this.vAY != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.vAY);
      }
      i = paramInt;
      if (this.vBs != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.vBs);
      }
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.nickname);
      }
      i = paramInt;
      if (this.vAM != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.vAM);
      }
      AppMethodBeat.o(91400);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91400);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        sa localsa = (sa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91400);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localsa.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91400);
          return 0;
        case 2: 
          localsa.tav = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91400);
          return 0;
        case 3: 
          localsa.nvC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91400);
          return 0;
        case 4: 
          localsa.vBp = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91400);
          return 0;
        case 5: 
          localsa.CTF = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91400);
          return 0;
        case 6: 
          localsa.vAX = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91400);
          return 0;
        case 7: 
          localsa.vAY = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91400);
          return 0;
        case 8: 
          localsa.vBs = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91400);
          return 0;
        case 9: 
          localsa.nickname = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91400);
          return 0;
        }
        localsa.vAM = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91400);
        return 0;
      }
      AppMethodBeat.o(91400);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sa
 * JD-Core Version:    0.7.0.1
 */