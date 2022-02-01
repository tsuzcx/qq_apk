package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class bml
  extends cpx
{
  public String Fbj;
  public String Fbl;
  public String Fbm;
  public b Fbn;
  public int Fbo;
  public String Fbp;
  public LinkedList<bna> Fbt;
  public String cJz;
  public String djj;
  public String signature;
  public String url;
  
  public bml()
  {
    AppMethodBeat.i(82444);
    this.Fbt = new LinkedList();
    AppMethodBeat.o(82444);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82445);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      if (this.djj != null) {
        paramVarArgs.d(3, this.djj);
      }
      if (this.Fbj != null) {
        paramVarArgs.d(4, this.Fbj);
      }
      if (this.cJz != null) {
        paramVarArgs.d(5, this.cJz);
      }
      if (this.Fbl != null) {
        paramVarArgs.d(6, this.Fbl);
      }
      if (this.signature != null) {
        paramVarArgs.d(7, this.signature);
      }
      if (this.Fbm != null) {
        paramVarArgs.d(8, this.Fbm);
      }
      if (this.Fbn != null) {
        paramVarArgs.c(9, this.Fbn);
      }
      paramVarArgs.aR(10, this.Fbo);
      paramVarArgs.e(11, 8, this.Fbt);
      if (this.Fbp != null) {
        paramVarArgs.d(12, this.Fbp);
      }
      AppMethodBeat.o(82445);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1046;
      }
    }
    label1046:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.url);
      }
      i = paramInt;
      if (this.djj != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.djj);
      }
      paramInt = i;
      if (this.Fbj != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Fbj);
      }
      i = paramInt;
      if (this.cJz != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.cJz);
      }
      paramInt = i;
      if (this.Fbl != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Fbl);
      }
      i = paramInt;
      if (this.signature != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.signature);
      }
      paramInt = i;
      if (this.Fbm != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Fbm);
      }
      i = paramInt;
      if (this.Fbn != null) {
        i = paramInt + f.a.a.b.b.a.b(9, this.Fbn);
      }
      i = i + f.a.a.b.b.a.bx(10, this.Fbo) + f.a.a.a.c(11, 8, this.Fbt);
      paramInt = i;
      if (this.Fbp != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.Fbp);
      }
      AppMethodBeat.o(82445);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Fbt.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(82445);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bml localbml = (bml)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82445);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbml.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82445);
          return 0;
        case 2: 
          localbml.url = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(82445);
          return 0;
        case 3: 
          localbml.djj = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(82445);
          return 0;
        case 4: 
          localbml.Fbj = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(82445);
          return 0;
        case 5: 
          localbml.cJz = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(82445);
          return 0;
        case 6: 
          localbml.Fbl = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(82445);
          return 0;
        case 7: 
          localbml.signature = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(82445);
          return 0;
        case 8: 
          localbml.Fbm = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(82445);
          return 0;
        case 9: 
          localbml.Fbn = ((f.a.a.a.a)localObject1).LVo.gfk();
          AppMethodBeat.o(82445);
          return 0;
        case 10: 
          localbml.Fbo = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(82445);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bna();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bna)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbml.Fbt.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82445);
          return 0;
        }
        localbml.Fbp = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(82445);
        return 0;
      }
      AppMethodBeat.o(82445);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bml
 * JD-Core Version:    0.7.0.1
 */