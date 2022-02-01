package com.tencent.mm.sdk.statecenter;

public abstract interface IProcessor<State extends BaseState>
{
  public abstract void process(State paramState);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sdk.statecenter.IProcessor
 * JD-Core Version:    0.7.0.1
 */