package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class qw
  extends dyl
{
  public int Ilb;
  public String Ilc;
  public String Ild;
  public String ImV;
  public String ImY;
  public String RZl;
  public int RZm;
  public int amount;
  public int channel;
  public String llO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91370);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.amount);
      paramVarArgs.aY(3, this.channel);
      paramVarArgs.aY(4, this.Ilb);
      if (this.RZl != null) {
        paramVarArgs.f(5, this.RZl);
      }
      if (this.ImV != null) {
        paramVarArgs.f(6, this.ImV);
      }
      if (this.Ilc != null) {
        paramVarArgs.f(7, this.Ilc);
      }
      if (this.ImY != null) {
        paramVarArgs.f(8, this.ImY);
      }
      if (this.llO != null) {
        paramVarArgs.f(9, this.llO);
      }
      if (this.Ild != null) {
        paramVarArgs.f(10, this.Ild);
      }
      paramVarArgs.aY(11, this.RZm);
      AppMethodBeat.o(91370);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label832;
      }
    }
    label832:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.amount) + g.a.a.b.b.a.bM(3, this.channel) + g.a.a.b.b.a.bM(4, this.Ilb);
      paramInt = i;
      if (this.RZl != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.RZl);
      }
      i = paramInt;
      if (this.ImV != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.ImV);
      }
      paramInt = i;
      if (this.Ilc != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.Ilc);
      }
      i = paramInt;
      if (this.ImY != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.ImY);
      }
      paramInt = i;
      if (this.llO != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.llO);
      }
      i = paramInt;
      if (this.Ild != null) {
        i = paramInt + g.a.a.b.b.a.g(10, this.Ild);
      }
      paramInt = g.a.a.b.b.a.bM(11, this.RZm);
      AppMethodBeat.o(91370);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91370);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        qw localqw = (qw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91370);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jg localjg = new jg();
            if ((localObject != null) && (localObject.length > 0)) {
              localjg.parseFrom((byte[])localObject);
            }
            localqw.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(91370);
          return 0;
        case 2: 
          localqw.amount = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91370);
          return 0;
        case 3: 
          localqw.channel = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91370);
          return 0;
        case 4: 
          localqw.Ilb = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91370);
          return 0;
        case 5: 
          localqw.RZl = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91370);
          return 0;
        case 6: 
          localqw.ImV = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91370);
          return 0;
        case 7: 
          localqw.Ilc = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91370);
          return 0;
        case 8: 
          localqw.ImY = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91370);
          return 0;
        case 9: 
          localqw.llO = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91370);
          return 0;
        case 10: 
          localqw.Ild = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91370);
          return 0;
        }
        localqw.RZm = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(91370);
        return 0;
      }
      AppMethodBeat.o(91370);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qw
 * JD-Core Version:    0.7.0.1
 */