package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bfc
  extends dop
{
  public String LOM;
  public int LON;
  public String egX;
  public String fuJ;
  public String fuK;
  public int msgType;
  public String yQE;
  public String yXR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(214295);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.egX != null) {
        paramVarArgs.e(2, this.egX);
      }
      if (this.yQE != null) {
        paramVarArgs.e(3, this.yQE);
      }
      if (this.LOM != null) {
        paramVarArgs.e(4, this.LOM);
      }
      if (this.fuJ != null) {
        paramVarArgs.e(5, this.fuJ);
      }
      if (this.fuK != null) {
        paramVarArgs.e(6, this.fuK);
      }
      if (this.yXR != null) {
        paramVarArgs.e(7, this.yXR);
      }
      paramVarArgs.aM(8, this.msgType);
      paramVarArgs.aM(9, this.LON);
      AppMethodBeat.o(214295);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label770;
      }
    }
    label770:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.egX != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.egX);
      }
      i = paramInt;
      if (this.yQE != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.yQE);
      }
      paramInt = i;
      if (this.LOM != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.LOM);
      }
      i = paramInt;
      if (this.fuJ != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.fuJ);
      }
      paramInt = i;
      if (this.fuK != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.fuK);
      }
      i = paramInt;
      if (this.yXR != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.yXR);
      }
      paramInt = g.a.a.b.b.a.bu(8, this.msgType);
      int j = g.a.a.b.b.a.bu(9, this.LON);
      AppMethodBeat.o(214295);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(214295);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bfc localbfc = (bfc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(214295);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbfc.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(214295);
          return 0;
        case 2: 
          localbfc.egX = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(214295);
          return 0;
        case 3: 
          localbfc.yQE = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(214295);
          return 0;
        case 4: 
          localbfc.LOM = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(214295);
          return 0;
        case 5: 
          localbfc.fuJ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(214295);
          return 0;
        case 6: 
          localbfc.fuK = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(214295);
          return 0;
        case 7: 
          localbfc.yXR = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(214295);
          return 0;
        case 8: 
          localbfc.msgType = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(214295);
          return 0;
        }
        localbfc.LON = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(214295);
        return 0;
      }
      AppMethodBeat.o(214295);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfc
 * JD-Core Version:    0.7.0.1
 */