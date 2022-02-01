package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ht
  extends dyl
{
  public int CQK;
  public String Dtb;
  public String RMH;
  public String RMK;
  public int RML;
  public eae RMN;
  public eae RNl;
  public String mVB;
  public String rVG;
  public String vhp;
  public String vhq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133150);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RNl == null)
      {
        paramVarArgs = new b("Not all required fields were included: AxTicket");
        AppMethodBeat.o(133150);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.CQK);
      if (this.RNl != null)
      {
        paramVarArgs.oE(3, this.RNl.computeSize());
        this.RNl.writeFields(paramVarArgs);
      }
      if (this.Dtb != null) {
        paramVarArgs.f(4, this.Dtb);
      }
      if (this.RMH != null) {
        paramVarArgs.f(5, this.RMH);
      }
      if (this.mVB != null) {
        paramVarArgs.f(6, this.mVB);
      }
      if (this.rVG != null) {
        paramVarArgs.f(7, this.rVG);
      }
      if (this.RMK != null) {
        paramVarArgs.f(8, this.RMK);
      }
      if (this.vhq != null) {
        paramVarArgs.f(9, this.vhq);
      }
      if (this.vhp != null) {
        paramVarArgs.f(10, this.vhp);
      }
      paramVarArgs.aY(11, this.RML);
      if (this.RMN != null)
      {
        paramVarArgs.oE(12, this.RMN.computeSize());
        this.RMN.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133150);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1124;
      }
    }
    label1124:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.CQK);
      paramInt = i;
      if (this.RNl != null) {
        paramInt = i + g.a.a.a.oD(3, this.RNl.computeSize());
      }
      i = paramInt;
      if (this.Dtb != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.Dtb);
      }
      paramInt = i;
      if (this.RMH != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.RMH);
      }
      i = paramInt;
      if (this.mVB != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.mVB);
      }
      paramInt = i;
      if (this.rVG != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.rVG);
      }
      i = paramInt;
      if (this.RMK != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.RMK);
      }
      paramInt = i;
      if (this.vhq != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.vhq);
      }
      i = paramInt;
      if (this.vhp != null) {
        i = paramInt + g.a.a.b.b.a.g(10, this.vhp);
      }
      i += g.a.a.b.b.a.bM(11, this.RML);
      paramInt = i;
      if (this.RMN != null) {
        paramInt = i + g.a.a.a.oD(12, this.RMN.computeSize());
      }
      AppMethodBeat.o(133150);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.RNl == null)
        {
          paramVarArgs = new b("Not all required fields were included: AxTicket");
          AppMethodBeat.o(133150);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133150);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ht localht = (ht)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133150);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jg)localObject2).parseFrom((byte[])localObject1);
            }
            localht.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133150);
          return 0;
        case 2: 
          localht.CQK = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(133150);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eae();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eae)localObject2).dd((byte[])localObject1);
            }
            localht.RNl = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133150);
          return 0;
        case 4: 
          localht.Dtb = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133150);
          return 0;
        case 5: 
          localht.RMH = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133150);
          return 0;
        case 6: 
          localht.mVB = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133150);
          return 0;
        case 7: 
          localht.rVG = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133150);
          return 0;
        case 8: 
          localht.RMK = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133150);
          return 0;
        case 9: 
          localht.vhq = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133150);
          return 0;
        case 10: 
          localht.vhp = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133150);
          return 0;
        case 11: 
          localht.RML = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(133150);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eae();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eae)localObject2).dd((byte[])localObject1);
          }
          localht.RMN = ((eae)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(133150);
        return 0;
      }
      AppMethodBeat.o(133150);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ht
 * JD-Core Version:    0.7.0.1
 */