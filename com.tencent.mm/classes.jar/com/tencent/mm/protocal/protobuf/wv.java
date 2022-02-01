package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class wv
  extends cvw
{
  public int Gou;
  public LinkedList<cxn> Gov;
  public String Gow;
  public String Gox;
  public int Scene;
  public String gvv;
  public int ucK;
  public String uvF;
  public String uvT;
  
  public wv()
  {
    AppMethodBeat.i(124468);
    this.Gov = new LinkedList();
    AppMethodBeat.o(124468);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124469);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.ucK);
      if (this.uvF != null) {
        paramVarArgs.d(3, this.uvF);
      }
      if (this.uvT != null) {
        paramVarArgs.d(4, this.uvT);
      }
      if (this.gvv != null) {
        paramVarArgs.d(5, this.gvv);
      }
      paramVarArgs.aS(6, this.Gou);
      paramVarArgs.e(7, 8, this.Gov);
      if (this.Gow != null) {
        paramVarArgs.d(8, this.Gow);
      }
      if (this.Gox != null) {
        paramVarArgs.d(9, this.Gox);
      }
      paramVarArgs.aS(10, this.Scene);
      AppMethodBeat.o(124469);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label890;
      }
    }
    label890:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.ucK);
      paramInt = i;
      if (this.uvF != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.uvF);
      }
      i = paramInt;
      if (this.uvT != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.uvT);
      }
      paramInt = i;
      if (this.gvv != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.gvv);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.Gou) + f.a.a.a.c(7, 8, this.Gov);
      paramInt = i;
      if (this.Gow != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Gow);
      }
      i = paramInt;
      if (this.Gox != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.Gox);
      }
      paramInt = f.a.a.b.b.a.bz(10, this.Scene);
      AppMethodBeat.o(124469);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Gov.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(124469);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        wv localwv = (wv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124469);
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
            localwv.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124469);
          return 0;
        case 2: 
          localwv.ucK = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(124469);
          return 0;
        case 3: 
          localwv.uvF = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(124469);
          return 0;
        case 4: 
          localwv.uvT = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(124469);
          return 0;
        case 5: 
          localwv.gvv = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(124469);
          return 0;
        case 6: 
          localwv.Gou = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(124469);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localwv.Gov.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124469);
          return 0;
        case 8: 
          localwv.Gow = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(124469);
          return 0;
        case 9: 
          localwv.Gox = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(124469);
          return 0;
        }
        localwv.Scene = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(124469);
        return 0;
      }
      AppMethodBeat.o(124469);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.wv
 * JD-Core Version:    0.7.0.1
 */