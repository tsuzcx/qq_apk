package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class vg
  extends cvw
{
  public String GmV;
  public String Gnb;
  public String Gnc;
  public int Gnd;
  public String Gne;
  public String Gnf;
  public String Gng;
  public String Gnh;
  public int Gni;
  public int channel;
  public int vxx;
  public String yoN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72437);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Gnb == null)
      {
        paramVarArgs = new b("Not all required fields were included: receiver_name");
        AppMethodBeat.o(72437);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Gnb != null) {
        paramVarArgs.d(2, this.Gnb);
      }
      paramVarArgs.aS(3, this.vxx);
      if (this.Gnc != null) {
        paramVarArgs.d(4, this.Gnc);
      }
      if (this.yoN != null) {
        paramVarArgs.d(5, this.yoN);
      }
      paramVarArgs.aS(6, this.Gnd);
      paramVarArgs.aS(7, this.channel);
      if (this.Gne != null) {
        paramVarArgs.d(8, this.Gne);
      }
      if (this.GmV != null) {
        paramVarArgs.d(9, this.GmV);
      }
      if (this.Gnf != null) {
        paramVarArgs.d(10, this.Gnf);
      }
      if (this.Gng != null) {
        paramVarArgs.d(11, this.Gng);
      }
      if (this.Gnh != null) {
        paramVarArgs.d(12, this.Gnh);
      }
      paramVarArgs.aS(13, this.Gni);
      AppMethodBeat.o(72437);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1030;
      }
    }
    label1030:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Gnb != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Gnb);
      }
      i += f.a.a.b.b.a.bz(3, this.vxx);
      paramInt = i;
      if (this.Gnc != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Gnc);
      }
      i = paramInt;
      if (this.yoN != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.yoN);
      }
      i = i + f.a.a.b.b.a.bz(6, this.Gnd) + f.a.a.b.b.a.bz(7, this.channel);
      paramInt = i;
      if (this.Gne != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Gne);
      }
      i = paramInt;
      if (this.GmV != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.GmV);
      }
      paramInt = i;
      if (this.Gnf != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.Gnf);
      }
      i = paramInt;
      if (this.Gng != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.Gng);
      }
      paramInt = i;
      if (this.Gnh != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.Gnh);
      }
      i = f.a.a.b.b.a.bz(13, this.Gni);
      AppMethodBeat.o(72437);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.Gnb == null)
        {
          paramVarArgs = new b("Not all required fields were included: receiver_name");
          AppMethodBeat.o(72437);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72437);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        vg localvg = (vg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72437);
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
            localvg.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72437);
          return 0;
        case 2: 
          localvg.Gnb = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72437);
          return 0;
        case 3: 
          localvg.vxx = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72437);
          return 0;
        case 4: 
          localvg.Gnc = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72437);
          return 0;
        case 5: 
          localvg.yoN = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72437);
          return 0;
        case 6: 
          localvg.Gnd = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72437);
          return 0;
        case 7: 
          localvg.channel = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72437);
          return 0;
        case 8: 
          localvg.Gne = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72437);
          return 0;
        case 9: 
          localvg.GmV = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72437);
          return 0;
        case 10: 
          localvg.Gnf = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72437);
          return 0;
        case 11: 
          localvg.Gng = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72437);
          return 0;
        case 12: 
          localvg.Gnh = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72437);
          return 0;
        }
        localvg.Gni = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(72437);
        return 0;
      }
      AppMethodBeat.o(72437);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vg
 * JD-Core Version:    0.7.0.1
 */