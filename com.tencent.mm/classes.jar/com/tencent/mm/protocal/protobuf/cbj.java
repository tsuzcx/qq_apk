package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cbj
  extends cld
{
  public String Cue;
  public String Cuf;
  public String DRy;
  public String DXA;
  public String DXB;
  public String DXC;
  public String DXz;
  public String content;
  public boolean ntS;
  public String nti;
  public int status;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114055);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Cue != null) {
        paramVarArgs.d(2, this.Cue);
      }
      if (this.Cuf != null) {
        paramVarArgs.d(3, this.Cuf);
      }
      paramVarArgs.aR(4, this.status);
      if (this.content != null) {
        paramVarArgs.d(5, this.content);
      }
      if (this.nti != null) {
        paramVarArgs.d(6, this.nti);
      }
      if (this.DRy != null) {
        paramVarArgs.d(7, this.DRy);
      }
      paramVarArgs.bg(8, this.ntS);
      if (this.DXz != null) {
        paramVarArgs.d(9, this.DXz);
      }
      if (this.DXA != null) {
        paramVarArgs.d(10, this.DXA);
      }
      if (this.DXB != null) {
        paramVarArgs.d(11, this.DXB);
      }
      if (this.DXC != null) {
        paramVarArgs.d(12, this.DXC);
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
    for (int i = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Cue != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Cue);
      }
      i = paramInt;
      if (this.Cuf != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Cuf);
      }
      i += f.a.a.b.b.a.bA(4, this.status);
      paramInt = i;
      if (this.content != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.content);
      }
      i = paramInt;
      if (this.nti != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.nti);
      }
      paramInt = i;
      if (this.DRy != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.DRy);
      }
      i = paramInt + (f.a.a.b.b.a.fY(8) + 1);
      paramInt = i;
      if (this.DXz != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.DXz);
      }
      i = paramInt;
      if (this.DXA != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.DXA);
      }
      paramInt = i;
      if (this.DXB != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.DXB);
      }
      i = paramInt;
      if (this.DXC != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.DXC);
      }
      AppMethodBeat.o(114055);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(114055);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cbj localcbj = (cbj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114055);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcbj.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114055);
          return 0;
        case 2: 
          localcbj.Cue = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(114055);
          return 0;
        case 3: 
          localcbj.Cuf = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(114055);
          return 0;
        case 4: 
          localcbj.status = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(114055);
          return 0;
        case 5: 
          localcbj.content = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(114055);
          return 0;
        case 6: 
          localcbj.nti = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(114055);
          return 0;
        case 7: 
          localcbj.DRy = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(114055);
          return 0;
        case 8: 
          localcbj.ntS = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(114055);
          return 0;
        case 9: 
          localcbj.DXz = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(114055);
          return 0;
        case 10: 
          localcbj.DXA = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(114055);
          return 0;
        case 11: 
          localcbj.DXB = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(114055);
          return 0;
        }
        localcbj.DXC = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(114055);
        return 0;
      }
      AppMethodBeat.o(114055);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbj
 * JD-Core Version:    0.7.0.1
 */